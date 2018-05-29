<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.*"%>
<!DOCTYPE html>
<body>
    <form name="login" action="FrontController" method="post">
        <%
            Object Value2 = session.getAttribute("error");

            String msg = (String) Value2;
            if (msg != null) {
        %>
        <%=msg%>
        <% }%>
        <%Object liu = session.getAttribute("LoggedInUser");
            if (liu != null) {
            User LoggedUser = (User) liu;
        %>
        <p>You're already logged in as <%=LoggedUser.getUserName()%>. If you wish to log in as someone else, you'll have to <a href="index.jsp?page=logout">log out</a> first.</p>
        <% } else { %>
        Username: <input name="userName" size=30 type="text" maxlength="30" placeholder="Username"/>

        Password: <input name="password" size=20 type="password" placeholder="Password"/>
        <input type="hidden" name ="action" value="login" />
        <input type="submit"  value="Login" />
        <% }%>
    </form>
</body>
