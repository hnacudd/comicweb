/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class BookDAO extends DBContext {

    public boolean checkBookInBookCase(String bookID,String bookcaseID) throws Exception{
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            conn=new DBContext().getConnection();
            String query="select * from Contain where BookCaseID=? and BookID=?";
            ps=conn.prepareStatement(query);
            ps.setString(1,bookcaseID);
            ps.setString(2, bookID);
            rs=ps.executeQuery();
            while(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeConnection(rs,ps,conn);
        }
        return false;
    } 
    
    public Book getBookByID(String bookID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String img=null;
        try {
            conn = new DBContext().getConnection();
            String query = "SELECT * FROM Book where BookID=?";
            img=new DBContext().getImage();
            ps = conn.prepareStatement(query);
            ps.setString(1, bookID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book(rs.getString("BookID"),
                        rs.getString("BookTitle"),
                        rs.getString("Author"),
                        rs.getString("Brief"),
                        rs.getString("Publisher"),
                        img+rs.getString("Image"),
                        rs.getString("Content"),
                        rs.getString("Category")
                );
                return b;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection(rs, ps, conn);
        }
        return null;
    }
    public int getTotalBook() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        String query = "select count(*) from dbo.Book";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
        return 0;
    }

    public List<Book> pagingBook(int index) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dbImage = new DBContext();
        String link_img = null;
        List<Book> list = new ArrayList<>();
        try {
            String query = "Select * from dbo.Book \n"
                    + "order by BookID \n"
                    + "offset ? rows fetch next 15 rows only;";
            link_img = dbImage.getImage();
            conn = dbImage.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 15);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getString("BookID"),
                        rs.getString("bookTitle"),
                        rs.getString("author"),
                        rs.getString("brief"),
                        rs.getString("publisher"),
                        link_img + rs.getString("Image"),
                        rs.getString("content"),
                        rs.getString("category"))
                );
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
        return null;
    }

    public List<Book> get5Book() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dbImage = new DBContext();
        List<Book> list = new ArrayList<>();
        String link_img = null;
        try {
            conn = dbImage.getConnection();
            String query = "select TOP 5 * from Book";
            link_img = dbImage.getImage();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book(rs.getString("BookID"),
                        rs.getString("bookTitle"),
                        rs.getString("author"),
                        rs.getString("brief"),
                        rs.getString("publisher"),
                        link_img + rs.getString("Image"),
                        rs.getString("content"),
                        rs.getString("category"));
                list.add(b);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    public List<Book> getAllBook() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dbImage = new DBContext();
        List<Book> list = new ArrayList<>();
        String link_img = null;
        try {
            conn = dbImage.getConnection();
            String query = "select * from Book";
            link_img = dbImage.getImage();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book(rs.getString("BookID"),
                        rs.getString("bookTitle"),
                        rs.getString("author"),
                        rs.getString("brief"),
                        rs.getString("publisher"),
                        link_img + rs.getString("Image"),
                        rs.getString("content"),
                        rs.getString("category"));
                list.add(b);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    public List<Book> getBookFromBookcaseByUser(int userID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            String query = "SELECT b.BookID,bc.BookCaseID,b.BookTitle,bc.BookCaseName from Book b inner join Contain c on b.BookID = c.BookID inner join BookCase bc on bc.BookCaseID = c.BookCaseID\n"
                    + "inner join userInfor ui on ui.BookCaseID = bc.BookCaseID where ui.userID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book(rs.getString("bookID"),
                        rs.getInt("bookCaseID"),
                        rs.getString("BookTitle"),
                        rs.getString("BookCaseName"));
                list.add(b);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    public void clearAllBookInBookcase(int bookCaseID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            String sql = "DELETE FROM dbo.Contain where BookCaseID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bookCaseID);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }
    public void addNewBook(String bookTitle, String author, String brief, String publisher, String content, String category, String image) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "INSERT into Book(bookTitle, author, brief, publisher, content, category, image) values(?,?,?,?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, bookTitle);
            ps.setString(2, author);
            ps.setString(3, brief);
            ps.setString(4, publisher);
            ps.setString(5, content);
            ps.setString(6, category);
            ps.setString(7, image);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    public void updateBook(int bookID, String bookTitle, String author, String brief, String publisher, String content, String category, String image) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //(bookTitle, author, brief, publisher, content, category, image) 
            String query = "UPDATE [dbo].Book SET bookTitle = ?,author = ?, brief = ?, publisher = ?, content = ?, category = ?, image = ? WHERE bookID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, bookTitle);
            ps.setString(2, author);
            ps.setString(3, brief);
            ps.setString(4, publisher);
            ps.setString(5, content);
            ps.setString(6, category);
            ps.setString(7, image);
            ps.setInt(8, bookID);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    public void deleteBookOnDBOBook(int bookID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //(bookTitle, author, brief, publisher, content, category, image) 
            String query = "DELETE FROM [dbo].Book WHERE bookID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, bookID);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    public void deleteBookOnDBOContain(int bookID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //(bookTitle, author, brief, publisher, content, category, image) 
            String query = "DELETE FROM [dbo].Contain WHERE bookID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, bookID);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
    }

    public int getTotalBookSearch(String bookTitle) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        String query = "select count(*) from dbo.Book WHERE [BookTitle] LIKE '%" + bookTitle + "%'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
        return 0;
    }

    public List<Book> searchBookByTitle(int index, String bookTitle) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        String link_img = null;
        String query = "Select * from dbo.Book WHERE [BookTitle] LIKE '%" + bookTitle + "%'\n"
                + "order by BookID \n"
                + "offset ? rows fetch next 10 rows only;";
        try {
           // int bookid, String bookTitle, String author, String brief, String publisher, String image, String content, String category
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            link_img = new DBContext().getImage();
            while (rs.next()) {
                Book b = new Book(
                        rs.getString("bookID"),
                        rs.getString("bookTitle"),
                        rs.getString("author"),
                        rs.getString("brief"),
                        rs.getString("publisher"),
                        link_img + rs.getString("Image"),
                        rs.getString("content"),
                        rs.getString("category")
                        );
                list.add(b);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
        return null;
    }
    public int getTotalBookInBookCase(int userID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT count(b.BookID) from Book b inner join Contain c on b.BookID = c.BookID inner join BookCase bc on bc.BookCaseID = c.BookCaseID inner join userInfor ui on ui.BookCaseID = bc.BookCaseID where ui.userID = ? group by \n"
                + "bc.BookCaseID";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, conn);
        }
        return 0;
    }
    public List<Book> getBookFromBookcaseByUser(int userID, int index) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dbImage = new DBContext();
        List<Book> list = new ArrayList<>();
        String link_img = null;
        try {
            conn = dbImage.getConnection();
            String query = "SELECT b.BookID,b.BookTitle,b.Image,b.Author,b.Category,bc.BookCaseName,b.Brief,c.CreateDate from Book b inner join Contain c on b.BookID = c.BookID inner join BookCase bc on bc.BookCaseID = c.BookCaseID\n"
                    + "inner join userInfor ui on ui.BookCaseID = bc.BookCaseID where ui.userID = ? order by b.BookID offset ? rows fetch next 5 rows only";
            link_img = dbImage.getImage();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setInt(2, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book(rs.getString("bookID"),
                        rs.getString("BookTitle"),
                        link_img + rs.getString("Image"),
                        rs.getString("Author"),
                        rs.getString("Category"),
                        rs.getString("BookCaseName"),
                        rs.getString("Brief"),
                        rs.getDate("CreateDate"));
                list.add(b);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }
    public void deleteBookInBookcase(int bookID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().getConnection();
            String sql = "DELETE FROM dbo.Contain WHERE BookID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bookID);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(rs, ps, conn);
        }
    }
    public void addBookToBookCase(String bookID, String bookcaseID) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = new DBContext().getConnection();
            String query = "insert into Contain(BookCaseID,BookID,CreateDate)\n" +
"values(?,?,?)";
            ps=conn.prepareStatement(query);
            ps.setString(1, bookcaseID);
            ps.setString(2, bookID);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            ps.setString(3, formatter.format(date));
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeConnection(rs,ps,conn);
        }
    }

}
