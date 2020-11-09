<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%> <%@taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String error = (String) request.getAttribute("error");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Title</title>
</head>

<body>
    <p> Please fill out this form with your name. Thanks!
    <form METHOD="POST" action="ServletLogin">
        <label>login:
            <input name="login" type="text" size="12" maxlength=" 20" />
        </label>
        <label>password:
            <input name="password" type="text" size="12" maxlength="20" />
        </label>
        <button type="submit">Submit</button>

        <c:if test="${error != null}" var="condition">
            <p style="color : red"> login error
                <p />
        </c:if>
        <form>

</body>

</html>