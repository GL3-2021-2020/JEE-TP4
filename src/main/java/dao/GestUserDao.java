package dao;

import java.sql.*;
import java.util.Vector;

import metier.Utilisateur;

public class GestUserDao {

    public Utilisateur loadUser(String login, String pass) {

        Connection conn = Utilitaire.getConnection();
        Utilisateur u = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from db.Utilisateurs where login=? and pass=?");
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rsUser = ps.executeQuery();
            if (rsUser.next()) {
                u = new Utilisateur();
                u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
                u.setLogin(rsUser.getString("LOGIN"));
                u.setPass(rsUser.getString("PASS"));
                u.setEmail(rsUser.getString("EMAIL"));
                u.setVille(rsUser.getString("VILLE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public void addUser(String l, String p, String e, String v) {
        Connection conn = Utilitaire.getConnection();
        Utilisateur u = null;
        System.out.println(l);
        try {
            PreparedStatement ps = conn
                    .prepareStatement("insert into db.Utilisateurs (LOGIN,PASS,EMAIL,VILLE) values(?,?,?,?)");
            ps.setString(1, l);
            ps.setString(2, p);
            ps.setString(3, e);
            ps.setString(4, v);
            ps.executeUpdate();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public Vector<Utilisateur> selectAll() {
        Connection conn = Utilitaire.getConnection();
        Vector<Utilisateur> users = new Vector<>();
        Utilisateur u = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from db.Utilisateurs");
            ResultSet rsUser = ps.executeQuery();
            while (rsUser.next()) {
                u = new Utilisateur();
                u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
                u.setLogin(rsUser.getString("LOGIN"));
                u.setPass(rsUser.getString("PASS"));
                u.setEmail(rsUser.getString("EMAIL"));
                u.setVille(rsUser.getString("VILLE"));
                users.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
