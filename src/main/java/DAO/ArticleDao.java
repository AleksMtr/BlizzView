package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.Article;

public class ArticleDao extends Dao implements ArticleDaoInterface {

    public ArticleDao(String databaseName) {
        super(databaseName);
    }

    /**
     * @param authorID
     * @param title
     * @param articleText
     * @return A boolean to show whether or not the article was posted
     */
    @Override
    public boolean PostArticle(int artID, int authorID, String title, String articleText) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try {
            con = getConnection();
            String query = "Insert into Article (artID, authorID, title, articleText, published) values(?,?,?,?,NOW())";
            ps = con.prepareStatement(query);
            ps.setInt(1, artID);
            ps.setInt(2, authorID);
            ps.setString(3, title);
            ps.setString(4, articleText);

            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception occurred in the PostArticle() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the final part of PostArticle()");
                e.getMessage();
            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return An ArrayList of all the articles in the database
     */
    @Override
    public ArrayList<Article> getArticles() {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> articles = new ArrayList();
        
        try{
            con = getReadConnection();

            String query = "SELECT * FROM Article ORDER BY published DESC";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Article a = new Article(rs.getInt("ArtID"), rs.getInt("AuthorID"), rs.getString("Title"), rs.getString("ArticleText"), rs.getString("published"));
                articles.add(a);
            }
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the getArticles() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the final part of getArticles(): " + e.getMessage());
            }
        }
        return articles;
    }
    
    @Override
    public boolean deleteArticle(int artID) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
            con = getConnection();
            String query = "DELETE FROM Article WHERE artID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, artID);    
            rowsAffected = ps.executeUpdate(); 
            
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the deleteArticle() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An exception has occurred in the final part of deleteArticle()");
                e.getMessage();
                
            }
        }
        return rowsAffected > 0;
    }
    
    @Override
    public boolean deleteArticleByAuthor(int aID) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
            con = getConnection();
            String query = "DELETE FROM Article WHERE artID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, aID);    
            rowsAffected = ps.executeUpdate(); 
            
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the deleteArticle() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An exception has occurred in the final part of deleteArticle()");
                e.getMessage();
                
            }
        }
        return rowsAffected > 0;
    }
    
    @Override
    public Article getArticleByID(int artID){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article a = null;
        
        try{
            con = getConnection();

            String query = "SELECT * FROM Article WHERE artID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, artID);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                a = new Article(rs.getInt("artID"), rs.getInt("authorID"), rs.getString("title"), rs.getString("articleText"), rs.getString("published"));
                
            }
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the getArticleByID() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An exception occurred in the final part of getArticleByID(): " + e.getMessage());
            }
        }
        return a;
    }
    
    @Override
    public boolean EditArticle(int articleID, String title, String text) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE Article SET title = ?, articletext = ? WHERE ArtID = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, text);
            ps.setInt(3, articleID);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("An exception has occurred in EditArticle(): " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An exception has occurred in the final part the EditArticle()");
                e.getMessage();
            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
