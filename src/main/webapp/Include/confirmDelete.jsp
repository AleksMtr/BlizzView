<%@page import="DTO.*"%>
<%@page import="DAO.*"%>
<%
    Object val = session.getAttribute("LoggedInUser");
    if (val != null) {
        User lIUs = (User) val;
%>
<h1>Delete Your Account</h1>
<p>Are you sure you want to permanently delete your account?</p>
<form name="login" action="FrontController" method="post">
    <input type="hidden" name ="userID" value="<%=lIUs.getUserID()%>" />
    <input type="hidden" name ="action" value="deleteUser" />
    <input type="submit"  value="Yes" />
</form>
    <form name="login" action="index.jsp?page=viewUser&user=<%=lIUs.getUserName()%>" method="post">
    <input type="submit"  value="No" />
</form>
<%} else {%>
<h1>You shouldn't be here</h1>
<p>You must be logged in to access this page.</p>
<%}%>