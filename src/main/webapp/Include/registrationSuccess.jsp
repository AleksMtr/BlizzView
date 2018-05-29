<%@page import="DTO.User"%>
<%@page import="DAO.UserDao"%>
<!DOCTYPE html>
<html>
    <body>
        <br />
        <div id="wrapper">
            <%
                Object Value2 = session.getAttribute("success");

                if (Value2 != null) {
                    User registeredUser = (User) Value2;

            %>
            <header>
                <h1>Congratulations on your successful registration and welcome to BlizzView, <%=registeredUser.getUserName()%></h1>
                <br/>
                <br/>
                <br/>
            </header>
            <%
                }
                session.removeAttribute("success");
            %>
        </div>
    </body>
</html>
