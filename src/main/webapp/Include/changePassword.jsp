<%@page import="DTO.*"%>
<%@page import="DAO.*"%>
<%
    Object Val = session.getAttribute("LoggedInUser");
    if (Val != null) {
        User lIUser = (User) Val;
%>
<h3>Edit your Profile</h3>
<form name="reg" action="FrontController" method="post">
    Old Password  :  <input name="oldPass" size=30 type="password" maxlength="20" placeholder="Old Password"  /><br>

    New Password : <input name="newPass" size=30 type="password" maxlength="30" placeholder="New Password" /><br>
    
    Confirm Password : <input name="confirmPass" size=30 type="password" maxlength="30" placeholder="Confirm Password" /><br>

    <input type="submit" id="btnSubmit" value="Change Password" />
    <input type="hidden" name ="userID" value="<%=lIUser.getUserID()%>" />
    <!-- Include a hidden field to identify what the user wants to do -->
    <input type="hidden" name ="action" value="editPasswd" />
</form>
    <%
    } else {
    %>
    <h3>You shouldn't be here!</h3>
    <br />
    <p>You need to be logged in to be able to change your password.</p>
    <br />
    <br />
    <br />
    <%
        }
    %>