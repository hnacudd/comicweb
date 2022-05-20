/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.User;

/**
 *
 * @author Dinh Tuan Minh
 */
public class UserDAO extends DBContext {

    public List<User> getAllUser() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            String query = "SELECT * FROM userInfor";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("userID"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getBoolean("roleID"),
                        rs.getInt("BookCaseID"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
        return null;
    }

    public void insertToBookCase(String BookCaseName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "INSERT INTO BookCase(BookCaseName) values (?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, BookCaseName);

            ps.executeUpdate();
            System.out.println("1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    public int getBookCaseIDByName(String bookCaseName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            String query = "SELECT * FROM BookCase where BookCaseName=? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, bookCaseName);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("BookCaseID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
        return -1;
    }

    public void registUser(String userName, String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "INSERT INTO userInfor(userName, password, roleID, BookCaseID) values (?,?,0,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);

            insertToBookCase(userName);
            int bookCaseID = getBookCaseIDByName(userName);
            ps.setInt(3, bookCaseID);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    
    public User checkLogin(String username, String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            String query = "SELECT * FROM userInfor where userName=? and password=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("userID"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getBoolean("roleID"),
                        rs.getInt("BookCaseID"));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
        return null;
    }
    public User getUserByName(String username) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            String query = "SELECT * FROM userInfor where userName=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("userID"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getBoolean("roleID"),
                        rs.getInt("BookCaseID"));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
        return null;
    }


//    public static void main(String[] args) throws Exception {
//        UserDAO userDAO = new UserDAO();
//        List<User> list = userDAO.getAllUser();
//        for (User user : list) {
//            System.out.println(user.getUserName());
//        }
//        //userDAO.registUser("11", "11");
//    }

}
