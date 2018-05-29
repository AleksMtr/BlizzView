<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BlizzView</title>
    </head>
    <body>
        <img id="imghead" src="Images/header.png">
        <%@include file = "Include/nav.jsp"%>
        <div id="container">
            <div id="cont2">
            <%            Object Value = session.getAttribute("LoggedInUser");
                UserDao uDao = new UserDao("Blizzview");

            %>
            <h1>
                <%                if (Value != null) {
                        User LoggedInUser = (User) Value;%>
                Welcome, <%=LoggedInUser.getUserName()%>
                <%
                    }
                %>
            </h1>
            <%
                String urlPage = request.getParameter("page");
                String article = request.getParameter("article");
                if (urlPage == null || urlPage.equals("") || urlPage.equals("article")) {
            %>
            <%@include file = "Include/home.jsp"%>
            <%        } else if (urlPage.equals("register")) {
            %>
            <%@include file="Include/register.jsp" %>
            <%        } else if (urlPage.equals("login")) {
            %>
            <%@include file="Include/login.jsp" %>
            <%        } else if (urlPage.equals("regSuccess")) {
            %>
            <%@include file="Include/registrationSuccess.jsp" %>
            <%        } else if (urlPage.equals("viewChar")) {
            %>
            <%@include file="Include/viewChar.jsp" %>
            <%        } else if (urlPage.equals("compare")) {
            %>
            <%@include file="Include/compareChars.jsp" %>
            <%        } else if (urlPage.equals("viewCompare")) {
            %>
            <%@include file="Include/viewCompare.jsp" %>
            <%        } else if (urlPage.equals("wowChar")) {
            %>
            <%@include file="Include/WoWChar.jsp" %>
            <%        } else if (urlPage.equals("viewUser")) {
            %>
            <%@include file="Include/viewUser.jsp"%>
            <%        } else if (urlPage.equals("viewArticle")) {
            %>
            <%@include file="Include/viewArticle.jsp"%>
            <%        } else if (urlPage.equals("logout")) {
                session.removeAttribute("LoggedInUser");
                response.sendRedirect("index.jsp");

            } else if (urlPage.equals("editArticle")) {
            %>
            <%@include file="Include/editArticle.jsp"%>
            <%        } else if (urlPage.equals("editComment")) {
            %>
            <%@include file="Include/editComment.jsp"%>
            <%        } else if (urlPage.equals("editProfile")) {
            %>
            <%@include file="Include/editProfile.jsp"%>
            <%        } else if (urlPage.equals("changePassword")) {
            %>
            <%@include file="Include/changePassword.jsp"%>
            <%        } else if (urlPage.equals("deleteProfile")) {
            %>
            <%@include file="Include/confirmDelete.jsp"%>
            <%        } else if (urlPage.equals("successDelete")) {
            %>
            <%@include file="Include/successDelete.jsp"%>
            <%        } else if (urlPage.equals("followers")) {
            %>
            <%@include file="Include/followers.jsp"%>
            <%        } else if (urlPage.equals("viewFollower")) {
            %>
            <%@include file="Include/D3Follower.jsp"%>
            <%        }
            %>
            
            </div>
            <footer>&copy; Aleksander Matraszek</footer>
        </div>
    </body>
</html>