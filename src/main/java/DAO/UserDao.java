package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DTO.User;
import java.util.ArrayList;

public class UserDao extends Dao implements UserDaoInterface{
    
    public UserDao(String databaseName) {
        super(databaseName);
    }
    
    /**
     * @param userID;
     * @param userName
     * @param email
     * @param password
     * @return 
     */
    @Override
    public boolean RegisterUser(int userID, String userName, String email, String password){
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "Insert into User (userID, username, email, password, joined, isAdmin, wowMain) values(?,?,?,?,NOW(),FALSE,'none')";
            ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setString(2, userName);
            ps.setString(3, email);
            ps.setString(4, password);
            
            rowsAffected = ps.executeUpdate(); 
            
        }catch (SQLException e) {
            System.out.println("Exception occured in the RegistorUser() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the RegistorUser() method");
                e.getMessage();
                
            }
        }
        if(rowsAffected > 0)
        {
        return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public ArrayList<User> GetAllUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList();
        User u = null;
        
        try{
            con = getReadConnection();

            String query = "SELECT * FROM User";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                 u = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("email"), rs.getString("password"), rs.getString("joined"), rs.getBoolean("isAdmin"),rs.getString("wowMain"));
                users.add(u);
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the getAllUsers() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllUsers() method: " + e.getMessage());
            }
        }
        
        return users;
    }
    
    /**
     * @param userName
     * @return userName
     */
    @Override
    public User getUserByUserName(String userName) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try{
            con = getReadConnection();

            String query = "SELECT * FROM User WHERE userName = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                u = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("email"), rs.getString("password"), rs.getString("joined"), rs.getBoolean("isAdmin"),rs.getString("wowMain"));
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the getUserbyName() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getUserbyName() method: " + e.getMessage());
            }
        }
        
        return u;
    }
    
    /**
     * @param userID
     * @return User with that ID
     */
    @Override
    public User getUserByID(int userID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try{
            con = getReadConnection();

            String query = "SELECT * FROM User WHERE userID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                u = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("email"), rs.getString("password"), rs.getString("joined"), rs.getBoolean("isAdmin"),rs.getString("wowMain"));
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the getUserbyName() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getUserbyName() method: " + e.getMessage());
            }
        }
        return u;
    }
    /**
     * @param userID
     * @return userName of the user with that ID
     */
    @Override
    public String GetAuthorByID(int userID) {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name = null;
        try{
            con = getReadConnection();

            String query = "SELECT userName FROM User WHERE userID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
              name = rs.getString("username");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the GetAuthorByID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the GetAuthorByID() method: " + e.getMessage());
            }
        }
        
        return name;
    }
    
    /**
     * @param name
     * @param password
     * @return user with that username & password
     */
    @Override
    public User LogIn(String name, String password) {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try{
            con = getReadConnection();

            String query = "SELECT * FROM User WHERE userName = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();

            while(rs.next())
            {
                u = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("email"), rs.getString("password"), rs.getString("joined"), rs.getBoolean("isAdmin"),rs.getString("wowMain"));
            }
 
        }catch (SQLException e) {
            System.out.println("Exception occured in the LogingInUser() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the RemoveUser() method");
                e.getMessage();
                
            }
        }
        return u;
    }
    
    @Override
    public boolean ChangePassword(String password, int id) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE User SET password = ? WHERE userID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, password);
            ps.setInt(2, id);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ChangePassword method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the EditProfile method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean DeleteUser(int id) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "DELETE FROM User WHERE userID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the DeleteUser method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the final section of the DeleteUser method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean AssignWoWMain(String WoWMain, int id) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE User SET WoWMain = ? WHERE userID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, WoWMain);
            ps.setInt(2, id);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ChangePassword method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the EditProfile method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean EditProfile(String username, String email, int id) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE User SET userName = ?, email = ? WHERE userID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setInt(3, id);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ChangePassword method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the EditProfile method");
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
     * @param email
     * @return userName of the user with that email address
     */
    @Override
    public String GetUserNameByEmail(String email) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name = null;
        try{
            con = getReadConnection();

            String query = "SELECT userName FROM User WHERE email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
              name = rs.getString("username");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the GetName() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the GetName() method: " + e.getMessage());
            }
        }
        return name;
    }
}
