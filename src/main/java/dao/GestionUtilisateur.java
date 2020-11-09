package dao;

import java.util.Vector;

import metier.Utilisateur;

public class GestionUtilisateur {
    GestUserDao dao;

    public GestionUtilisateur() {
        dao = new GestUserDao();
    }

    public Utilisateur Chercher(String login, String pass) {
        return dao.loadUser(login, pass);
    }

    public void ajouter(Utilisateur u) {
        dao.addUser(u.getLogin(), u.getPass(), u.getEmail(), u.getVille());
    }

    public Vector<Utilisateur> lister() {
        return dao.selectAll();
    }

}
