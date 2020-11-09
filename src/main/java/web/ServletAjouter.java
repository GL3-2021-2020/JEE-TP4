package web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestionUtilisateur;
import metier.Utilisateur;

@WebServlet(name = "ajouter", urlPatterns = { "/ajouter" })
public class ServletAjouter extends HttpServlet {
    private static final long serialVersionUID = 1825023232864573043L;

    private static final GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Vector<Utilisateur> users = gestionUtilisateur.lister();
        req.setAttribute("users", users);

        HttpSession maSession = req.getSession(false);

        if (maSession == null) {
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
        }

        Utilisateur user = (Utilisateur) maSession.getAttribute("user");
        if (user == null) {
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
        }

        req.setAttribute("data", user);

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String ville = req.getParameter("ville");
        Utilisateur utilisateur = new Utilisateur(0, login, password, email, ville);
        gestionUtilisateur.ajouter(utilisateur);

        Vector<Utilisateur> usersUpdated = gestionUtilisateur.lister();
        req.setAttribute("users", usersUpdated);
        RequestDispatcher rd = req.getRequestDispatcher("Bienvenue.jsp");
        rd.forward(req, resp);
    }
}
