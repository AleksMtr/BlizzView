<%@page import="DTO.*"%>
<%@page import="DAO.*"%>

<%
    Object Val = session.getAttribute("editArt");
    ArticleDao aDao = new ArticleDao("Blizzview");
    UserDao author = new UserDao("Blizzview");
    Article artc = new Article();
    if (Val != null) {
        artc = (Article) Val;
    }
    Object liu = session.getAttribute("LoggedInUser");
    User LoggedUser = new User();
    if (liu != null) {
        LoggedUser = (User) liu;
    }
    if (LoggedUser.isIsAdmin()) {
%>
<form action="FrontController" method="post"  id="form-index">
    <h2 class id="title">Edit your Article</h2>
    <div>
        <h3> Title:</h3> 
        <input name="title" size=30 type="text" value="<%=artc.getTitle()%>" id="input"/> 
        <h3>Text:</h3>
        <textarea rows="4" cols="50" name="content"><%=artc.getArticleText()%></textarea>
        <input type="submit" value="Post" id="button"/>
    </div>
    <input type="hidden" name="artID" value="<%=artc.getArtID()%>" />
    <input type="hidden" name="action" value="editArt" />
</form>
<%
    } else {
%>
<h1>You shouldn't be here, you're not an admin.</h1>
<%
}
%>