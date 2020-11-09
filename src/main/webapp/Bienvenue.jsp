<%@ page import="metier.Utilisateur" %> <%@ page
contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.Vector" %>


<%
Utilisateur user = (Utilisateur) request.getAttribute("data");
%>

<html>

<head>
  <title>Title</title>
</head>

<body>
  <div>
    <h1>
      <% out.println( "login :" +
        user.login + "\t,"); out.println("email :" + user.email+ "\t," );
        out.println( "ville :" + user.ville+ "\t" ); %>
    </h1>
    <form METHOD="POST" action="ajouter">

      <label>login:
        <input name="login" type="text" size="12" maxlength=" 20" />
      </label>

      <label>email:
        <input name="email" type="text" size="12" maxlength="20" />
      </label>
      <label>password:
        <input name="password" type="text" size="12" maxlength="20" />
      </label>

      <label>ville:
        <input name="ville" type="text" size="12" maxlength=" 20" />
      </label>

      <button type="submit">ajouter Utilisateur</button>
      <form>


        <table>
          <tr>
            <th>login</th>
            <th>email</th>
            <th>ville</th>
          </tr>
          <%
        Vector<Utilisateur> list = (Vector<Utilisateur>) request.getAttribute("users");
        for (Utilisateur it : list) {%>

          <tr>
            <td><%=it.login%>
            </td>

            <td><%=it.email%>
            </td>
            <td><%=it.ville%>
            </td>
          </tr>
          <%}%>
</table>
  </div>
</body>

</html>