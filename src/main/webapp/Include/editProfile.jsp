<%@page import="DTO.*"%>
<%@page import="DAO.*"%>
<%
    Object Val = session.getAttribute("LoggedInUser");
    if (Val != null) {
        User lIUser = (User) Val;
%>
<h3>Edit your Profile</h3>
<form name="reg" action="FrontController" method="post">
    Username  :  <input name="userName" size=30 type="text" maxlength="20" value="<%=lIUser.getUserName()%>" placeholder="Username"  /><br>

    Email Address : <input name="email" size=30 type="email" maxlength="30" value="<%=lIUser.getEmail()%>" placeholder="Email" /><br>

    <input type="submit" id="btnSubmit" value="Submit" />
    <input type="hidden" name ="userID" value="<%=lIUser.getUserID()%>" />
    <!-- Include a hidden field to identify what the user wants to do -->
    <input type="hidden" name ="action" value="editUser" />
</form>
    <h3>If you wish to change your password, you can do it below.</h3>
    <a href="index.jsp?page=changePassword">Change Password</a>
    <%
    } else {
    %>
    <h3>You shouldn't be here!</h3>
    <br />
    <p>You need to be logged in to be able to edit your profile.</p>
    <br />
    <br />
    <br />
    <%
        }
    %>