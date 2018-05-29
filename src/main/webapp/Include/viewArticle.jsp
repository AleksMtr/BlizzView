<%@page import="java.util.ArrayList"%>
<%@page import="DTO.*"%>
<%@page import="DAO.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String aID = request.getParameter("article");
            if (aID != null) {
                if (aID.contains(" ")) {
                    int spaceIndex = (aID.indexOf(" ") - 1);
                    aID = aID.substring(0, spaceIndex);
                }
                
                int artID = Integer.parseInt(aID);
                Object successArt = session.getAttribute("articleSuccess");
                ArticleDao aDao = new ArticleDao("Blizzview");
                UserDao author = new UserDao("Blizzview");
                CommentDao cDao = new CommentDao("Blizzview");
                Article artc = aDao.getArticleByID(artID);
                if (successArt != null) {
                    artc = (Article) successArt;
        %>
        <h2>Article posted Successfully!</h2>
        <%
            }
            Object liu = session.getAttribute("LoggedInUser");
            User LoggedUser = new User();
            if (liu != null) {
                LoggedUser = (User) liu;
            }
        %>
        <h1><%=artc.getTitle()%></h1>
        <h3>by <a id="AccountLink" href="index.jsp?page=viewUser&user=<%=author.GetAuthorByID(artc.getAuthorID())%>"><%= author.GetAuthorByID(artc.getAuthorID())%></a> on <%=artc.getPublished()%></h3>
        <section>
            <div class="Article">
                <br />
                <p id="viewArticle">
                    <%=artc.getArticleText()%>
                </p>
            </div>
        </section>
        <%
            if (LoggedUser.isIsAdmin()) {
        %>
        <form name="login" action="FrontController" method="post">
            <input type="hidden" name ="artID" value="<%=artc.getArtID()%>" />
            <input type="hidden" name ="action" value="deleteArticle" />
            <input type="submit"  value="Delete Article" />
        </form>
        <form name="login" action="FrontController" method="post">
            <input type="hidden" name ="artID" value="<%=artc.getArtID()%>" />
            <input type="hidden" name ="action" value="editArticle" />
            <input type="submit"  value="Edit Article" />
        </form>    
        <%}
            ArrayList<Comment> comments = new ArrayList(cDao.getCommentsByArticle(artc.getArtID()));
        %>
        <section>
            <h2>Comments</h2>
            <%                if (liu != null) {
            %> 
            <form action="FrontController" method="post">
                <textarea name="comment" />Type your comment here</textarea>
                <input type="submit" value="Post" />
                <input type="hidden" name="action" value="postComment" />
                <input type="hidden" name="artID" value="<%=artc.getArtID()%>" />
            </form>
            <%
                }
                if (!comments.isEmpty()) {
                    for (Comment c : comments) {
            %>
            <div>
                <h5><a id="AccountLink" href="index.jsp?page=viewUser&user=<%=author.GetAuthorByID(c.getcAuthor())%>"><%=author.GetAuthorByID(c.getcAuthor())%></a> on <%=c.getPublished()%></h5>
                <p><%=c.getCommText()%></p>
                <%
                    if (liu != null) {
                        if (c.getcAuthor() == LoggedUser.getUserID()) {
                %>
                <form name="login" action="FrontController" method="post">
                    <input type="hidden" name ="commID" value="<%=c.getCommID()%>" />
                    <input type="hidden" name="artID" value="<%=artc.getArtID()%>" />
                    <input type="hidden" name ="action" value="deleteComment" />
                    <input type="submit"  value="Delete Comment" />
                </form>
                <form name="login" action="FrontController" method="post">
                    <input type="hidden" name ="commID" value="<%=c.getCommID()%>" />
                    <input type="hidden" name="artID" value="<%=artc.getArtID()%>" />
                    <input type="hidden" name ="action" value="editComm" />
                    <input type="submit"  value="Edit Comment" />
                </form>
                <%
                        }
                    }
                %>
            </div>
            <%
                }
            } else {
            %>
            <h5>No comments posted yet</h5>
            <%
                }} else {
            %>
            <h1>
                Article not found.
            </h1>
            <p>
                
            </p>
            <%
                }
            %>
        </section>
    </body>
</html>
