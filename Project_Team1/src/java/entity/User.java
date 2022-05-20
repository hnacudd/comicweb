/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Dinh Tuan Minh
 */
public class User {
    private int userId;
    private String userName;
    private String password;
    private boolean roleId;
    private int bookCaseId;
    

    public User() {
    }

    public User(int userId, String userName, String password, boolean roleId, int bookCaseId) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.roleId = roleId;
        this.bookCaseId = bookCaseId;
    }
    public User(String username, String password, boolean roleID, int bookcaseID) {
        this.userName = username;
        this.password = password;
        this.roleId = roleID;
        this.bookCaseId = bookcaseID;
    }

    public User(String username, String password) {
       this.userName = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRoleId() {
        return roleId;
    }

    public void setRoleId(boolean roleId) {
        this.roleId = roleId;
    }

    public int getBookCaseId() {
        return bookCaseId;
    }

    public void setBookCaseId(int bookCaseId) {
        this.bookCaseId = bookCaseId;
    }
    
}
