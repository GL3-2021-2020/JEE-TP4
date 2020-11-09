package metier;

public class Utilisateur {
    public Integer idUser;
    public String login;
    public String pass;
    public String email;
    public String ville;

    public String getVille() {
        return ville;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Utilisateur(Integer idUser, String login, String pass, String email, String ville) {
        this.idUser = idUser;
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.ville = ville;
    }

    public Utilisateur() {
    }

}
