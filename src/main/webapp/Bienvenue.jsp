<%@ page import="metier.Utilisateur" %> <%@ page
contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Title</title>
  </head>

  <body>
    <div>
      <h1>
        <% Utilisateur user = (Utilisateur) request.getAttribute("data");
        out.println( "id :" + user.idUser + "\t," ); out.println( "login :" +
        user.login + "\t,"); out.println("email :" + user.email+ "\t," );
        out.println( "ville :" + user.ville+ "\t" ); %>
      </p>
    </div>
  </body>
</html>
