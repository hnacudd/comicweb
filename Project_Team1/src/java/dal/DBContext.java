package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The class contains method that connect to the database and close the
 * connection to database
 *
 * @author Dinh Tuan Minh
 */
public class DBContext {

    String image;

    public DBContext() {
        try {
            InitialContext initialContext = new InitialContext();
            Context enviromentContext = (Context) initialContext.lookup("java:comp/env");
            image = enviromentContext.lookup("image").toString();
        } catch (NamingException e) {
            System.out.println("Can't read config");
        }
    }

    public String getImage() {
        return image;
    }
   

    public Connection getConnection() {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BookManagement";
            String username = "sa1";
            String password = "826264";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Close ResultSet, PreparedStatement, Connection
     *
     * @param rs
     * @param ps
     * @param con
     * @throws SQLException
     */
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
