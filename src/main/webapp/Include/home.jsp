<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.*"%>
<%@page import="DAO.*"%>
<body>  
    <%
        ArticleDao aDao = new ArticleDao("Blizzview");
        UserDao authors = new UserDao("Blizzview");
        CommentDao cDao = new CommentDao("Blizzview");
        Object liu = session.getAttribute("LoggedInUser");
        if(liu != null){
        User LoggedUser = (User) liu;
        if(LoggedUser.isIsAdmin()){
    %>
    <form action="FrontController" method="post"  id="form-index">
        <h2 class id="title">Write an Article</h2>
            <div>
                <h3> Title:</h3> 
                <input name="title" size=30 type="text" id="input"/> 
                <h3>Text:</h3>
                <textarea rows="4" cols="50" name="content">Enter Text Here</textarea>
                <input type="submit" value="Post" id="button"/>
            </div>
            <input type="hidden" name="action" value="postArticle" />
    </form>
    <%
        }}
        ArrayList<Article> allArticles = new ArrayList(aDao.getArticles());
        for (Article a : allArticles) {
        int artID = a.getArtID();
            String title = a.getTitle();
            String author = authors.GetAuthorByID(a.getAuthorID());
            String published = a.getPublished();
            String artText = a.getArticleText();
            if (artText.length() > 150) {
                artText = artText.substring(0, 149) + "...";
            }
    %>
    <article>
        <section>
            <div>
                <h2><%=title%></h2>
                <h3>by <a href="index.jsp?page=viewUser&user=<%=author%>"><%= author%></a> on <%=published%></h3>
                <p><%=artText%> <a href="index.jsp?page=viewArticle&article=<%=artID%>">View Full Article</a></p>
                <%
                    ArrayList<Comment> allComments = new ArrayList(cDao.getCommentsByArticle(artID));
                %>
                <h5><%=allComments.size()%> Comment<%if (allComments.size() != 1) {%>s<%}%></h5>
            </div>
        </section>
        <%
            }
        %>
    </article>
</body>