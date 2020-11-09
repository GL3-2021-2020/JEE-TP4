package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionUtilisateur;
import metier.Utilisateur;

@WebServlet(name = "cs", urlPatterns = { "/" })
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1825023232864573043L;

    private static final GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Utilisateur result = gestionUtilisateur.Chercher(login, password);

        if (result != null) {
            req.setAttribute("data", result);
            RequestDispatcher rd = req.getRequestDispatcher("Bienvenue.jsp");
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            rd.forward(req, resp);
        }
    }
}