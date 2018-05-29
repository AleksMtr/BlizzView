package DAO;

import java.util.ArrayList;
import DTO.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDao  extends Dao implements CommentDaoInterface{
    
    public CommentDao(String databaseName) {
        super(databaseName);
    }
    
    /**
     * @param articleID
     * @return comments by articleID
     */
    @Override
    public ArrayList<Comment> getCommentsByArticle(int articleID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment c = null;
        ArrayList<Comment> comments = new ArrayList();
        try {
            con = getReadConnection();
            String query = "SELECT * FROM Comments WHERE artID = ? ORDER BY commID DESC";
            ps = con.prepareStatement(query);
            ps.setInt(1, articleID);
            rs = ps.executeQuery();
            while(rs.next())
            {
                c = new Comment(rs.getInt("commID"), rs.getInt("cAuthor"), rs.getInt("ArtID"), rs.getString("commText"), rs.getString("published"));
                comments.add(c);
            }
            
        } catch (SQLException e) {
            System.out.println("Exception occured in the getCommentsByArticle() method: " + e.getMessage());
        } finally {
            try {

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the final section of the getCommentsByArticle() method: " + e.getMessage());
            }
        }
        
        return comments;
    }
    
    /**
     * @param commID
     * @return comment by its ID
     */
    @Override
    public Comment getCommentByID(int commID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment c = null;
        try {
            con = getReadConnection();
            String query = "SELECT * FROM Comments WHERE commID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, commID);
            rs = ps.executeQuery();
            while(rs.next())
            {
                c = new Comment(rs.getInt("commID"), rs.getInt("cAuthor"), rs.getInt("ArtID"), rs.getString("commText"), rs.getString("published"));
            }
            
        } catch (SQLException e) {
            System.out.println("Exception occured in the getCommentsByArticle() method: " + e.getMessage());
        } finally {
            try {

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the final section of the getCommentsByArticle() method: " + e.getMessage());
            }
        }
        
        return c;
    }
    
    /**
     * @param commentID
     * @param commentText
     * @return Edits the users comment
     */
    @Override
    public boolean editComment(int commentID, String commentText) {
            Connection con = null;
            PreparedStatement ps = null;
            int rowsAffected = 0;
                try{
                    con = getConnection();

                    String query = "UPDATE Comments SET CommText = ? WHERE commID = ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1, commentText);
                    ps.setInt(2, commentID);
                    rowsAffected = ps.executeUpdate();

                }catch (SQLException e) {
                    System.out.println("Exception occured in the editComment() method: " + e.getMessage());

                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }
                        if (con != null) {
                            freeConnection(con);
                        }
                    } catch (SQLException e) {
                        System.out.println("Exception occured in the finally section of the editComment() method");
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
     * @return an ArrayList of comments
     */
    @Override
    public ArrayList<Comment> getComments() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment c = null;
        ArrayList<Comment> comments = new ArrayList();
        try {
            con = getReadConnection();
            String query = "SELECT * FROM Comments ORDER BY commID DESC";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                c = new Comment(rs.getInt("commID"), rs.getInt("cAuthor"), rs.getInt("ArtID"), rs.getString("commText"), rs.getString("published"));
                comments.add(c);
            }
            
        } catch (SQLException e) {
            System.out.println("Exception occured in the getCommentsByArticle() method: " + e.getMessage());
        } finally {
            try {

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the final section of the getCommentsByArticle() method: " + e.getMessage());
            }
        }
        return comments;
    }
    
    @Override
    public boolean deleteArticleComments(int artID) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
            con = getConnection();
            String query = "DELETE FROM Comments WHERE artID = ?";
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
    public boolean deleteAuthorComments(int aID) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
            con = getConnection();
            String query = "DELETE FROM Comments WHERE cAuthor = ?";
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
    
    /**
    * Returns the authors of comments
    * @param commentID
    * @param cAuthor
    * @param artID
    * @param commentText
    * @return Sets the comment set by a user
    */
    @Override
    public boolean writeComment(int commentID, int cAuthor, int artID, String commentText) {
            Connection con = null;
            PreparedStatement ps = null;
            Comment c = null;
            ResultSet rs = null;
            int rowsAffected = 0;
            try{
                con = getConnection();

                String query = "INSERT INTO Comments (commID, cAuthor, artID, commText, published) values(?,?,?,?,NOW())";
                ps = con.prepareStatement(query);
                ps.setInt(1,commentID);
                ps.setInt(2, cAuthor);
                ps.setInt(3, artID);
                ps.setString(4, commentText);
                
                rowsAffected = ps.executeUpdate();
            }catch (SQLException e) {
                System.out.println("Exception occurred in writeComment(): " + e.getMessage());

            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    System.out.println("An exception has occurred in the final part of writeComment()");
                    e.getMessage();

                }
            }
            if(rowsAffected > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
    }
    
    /**
     * @param commentID
     * @return Deletes the user's comment
     */
    @Override
    public boolean deleteComment(int commentID) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try {
            con = getConnection();
            String query = "DELETE FROM Comments WHERE commID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, commentID);
            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occurred in deleteComment(): " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An exception has occurred in the final part of deleteComment()");
                e.getMessage();
                
            }
        }
        return rowsAffected > 0;
    }
}
