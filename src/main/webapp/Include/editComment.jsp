<%@page import="DTO.*"%>
<%@page import="DAO.*"%>

<%
    Object Val = session.getAttribute("editComm");
    ArticleDao aDao = new ArticleDao("Blizzview");
    UserDao author = new UserDao("Blizzview");
    Comment comm = new Comment();
    if (Val != null) {
        comm = (Comment) Val;
    }
    Object liu = session.getAttribute("LoggedInUser");
    User LoggedUser = new User();
    if (liu != null) {
        LoggedUser = (User) liu;
    }
    if (LoggedUser.getUserID() == comm.getcAuthor()) {
%>
<form action="FrontController" method="post"  id="form-index">
    <h2 class id="title">Edit your Comment</h2>
    <div>
        <textarea rows="4" cols="50" name="content"><%=comm.getCommText()%></textarea>
        <input type="submit" value="Post" id="button"/>
    </div>
    <input type="hidden" name="cID" value="<%=comm.getCommID()%>" />
    <input type="hidden" name="action" value="editComment" />
</form>
<%
    } else {
%>
<h1>You shouldn't be here, this is not your comment.</h1>
<%
}
%>