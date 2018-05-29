package DAO;

import java.util.ArrayList;
import DTO.Comment;

public interface CommentDaoInterface {

    /**
     * @param articleID
     * @return comments by articleID
     */
    public ArrayList<Comment> getCommentsByArticle(int articleID);

    /**
     * @param artID
     * @return a boolean to show if the comments belonging to that article were
     * deleted
     */
    public boolean deleteArticleComments(int artID);

    /**
     * Returns the authors of comments
     *
     * @param commentID
     * @param cAuthor
     * @param artID
     * @param commentText
     * @return Sets the comment set by a user
     */
    public boolean writeComment(int commentID, int cAuthor, int artID, String commentText);

    /**
     * @return an ArrayList of comments
     */
    public ArrayList<Comment> getComments();

    /**
     * @param commentID
     * @return boolean to show if the comment was deleted
     */
    public boolean deleteComment(int commentID);
    
    /**
     * @param commID
     * @return comment by its ID
     */
    public Comment getCommentByID(int commID);
    
    /**
     * @param commentID
     * @param commentText
     * @return Edits the users comment
     */
    public boolean editComment(int commentID, String commentText);
    
    
    public boolean deleteAuthorComments(int aID);
}
