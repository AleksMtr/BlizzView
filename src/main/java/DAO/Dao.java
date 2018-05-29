package DAO;

/**
 *
 * @author AleksMtr
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    private String databaseName;

    public Dao(String databaseName) {
        this.databaseName = databaseName;
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://blizzview.cekqqp5dfngf.eu-west-1.rds.amazonaws.com:3306/" + databaseName;
        String username = "root";
        String password = "bviewdb1";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex1) {
            System.out.println("Failed to find driver class " + ex1.getMessage());
            System.exit(1);
        } catch (SQLException ex2) {
            System.out.println("Connection failed " + ex2.getMessage());
        }
        return con;
    }
    public Connection getReadConnection() {
        String url = "jdbc:mysql://bvread.cekqqp5dfngf.eu-west-1.rds.amazonaws.com:3306/" + databaseName;
        String username = "root";
        String password = "bviewdb1";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex1) {
            System.out.println("Failed to find driver class " + ex1.getMessage());
            System.exit(1);
        } catch (SQLException ex2) {
            System.out.println("Connection failed " + ex2.getMessage());
        }
        return con;
    }

    public void freeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to free connection: " + e.getMessage());
            System.exit(1);
        }
    }

}
