package DAO;

import java.util.ArrayList;
import DTO.User;

public interface UserDaoInterface {
    
    /**
     * 
     * @param userID;
     * @param userName
     * @param email
     * @param password
     * @return 
     */
    public boolean RegisterUser(int userID, String userName, String email, String password);
    
    /**
     * 
     * @return an ArrayList of all users
     */
    public ArrayList<User>GetAllUsers();
    
    /**
     * @param userName
     * @return Return details of the user whose username was entered
     */
    public User getUserByUserName(String userName);
    
    /**
     * @param userID
     * @return User with that ID
     */
    public User getUserByID(int userID);
    
    /**
     * @param userID
     * @return userName of the user with that ID
     */
    public String GetAuthorByID(int userID);
    
    /**
     * @param email
     * @return userName of the user with that email address
     */
    public String GetUserNameByEmail(String email);
    
    /**
     * @param name
     * @param password
     * @return user with that username & password
     */
    public User LogIn(String name, String password);
    
    /**
     * @param username
     * @param email
     * @param id
     * @return a boolean to confirm if the user was edited or not
     */
    public boolean EditProfile(String username, String email, int id);
    
    /**
     * @param WoWMain
     * @param id
     * @return a boolean to confirm if the WoWMain was set or not
     */
    public boolean AssignWoWMain(String WoWMain, int id);
    
    /**
     * @param password
     * @param id
     * @return a boolean to confirm if the password was changed or not
     */
    public boolean ChangePassword(String password, int id);
    
    /**
     * @param id
     * @return a boolean to confirm that the account has been deleted
     */
    public boolean DeleteUser(int id);
}
