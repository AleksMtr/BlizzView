<%@page import="DTO.*"%>
<%@page import="DAO.*"%>
<nav>
    <ul>
        <li>
            <a href="index.jsp"><h2>Home</h2></a>
        </li>
        <li>
            <a href="index.jsp?page=viewChar"><h2>View a Character</h2></a>
        </li>
        <li>
            <a href="index.jsp?page=followers"><h2>Diablo III Followers</h2></a>
        </li>
        <li>
            <a href="index.jsp?page=compare"><h2>Compare Characters</h2></a>
        </li>
        <%
            Object lu = session.getAttribute("LoggedInUser");
            if (lu != null) {
            User lIUser = (User) lu;
            String lUName = lIUser.getUserName();
        %>
        <li>
            <a href="index.jsp?page=viewUser&user=<%=lUName%>"><h2>Your Profile</h2></a>
        </li>
        <li>
            <a href="index.jsp?page=logout"><h2>Log Out</h2></a>
        </li>
        <%
        } else {
        %>
        <li>
            <a href="index.jsp?page=register"><h2>Register here</h2></a>
        </li>
        <li>
            <a href="index.jsp?page=login"><h2>Log in here</h2></a>
        </li>
        <%
            }
        %>
    </ul>
</nav>