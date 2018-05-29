package DAO;

import java.util.ArrayList;
import DTO.Article;

public interface ArticleDaoInterface {
    
    /**
     * @param authorID
     * @param title
     * @param articleText
     * @return A boolean to show whether or not the article was posted
     */
    public boolean PostArticle(int artID, int authorID, String title, String articleText);
    
    /**
     * @return An ArrayList of all the articles in the database
     */
    public ArrayList<Article> getArticles();
    
    /**
     * @param artID
     * @return An article with the specified ID
     */
    public Article getArticleByID(int artID);
    
    /**
     * @param artID
     * @return A boolean to show if the article with this ID was deleted
     */
    public boolean deleteArticle(int artID);
    
    public boolean deleteArticleByAuthor(int aID);
    
    public boolean EditArticle(int articleID, String title, String text);
}
