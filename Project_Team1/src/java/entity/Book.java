/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Book {

    private String bookID;
    private int bookid;
    private String bookTitle;
    private String author;
    private String brief;
    private String publisher;
    private String image;
    private String content;
    private String category;
    private int bookCaseID;
    private String bookCaseName;
    private Date createDate;

    public Book() {
    }

    public Book(int bookid, String bookTitle, String author, String brief, String publisher, String image, String content, String category) {
        this.bookid = bookid;
        this.bookTitle = bookTitle;
        this.author = author;
        this.brief = brief;
        this.publisher = publisher;
        this.image = image;
        this.content = content;
        this.category = category;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public Book(String bookID, int bookCaseID, String bookTitle, String bookCaseName) {
        this.bookID = bookID;
        this.bookCaseID = bookCaseID;
        this.bookTitle = bookTitle;
        this.bookCaseName = bookCaseName;
    }
    public Book(String bookID, String bookTitle, String image, String author, String category, String bookCaseName, String brief, Date createDate) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.image = image;
        this.author = author;
        this.category = category;
        this.bookCaseName = bookCaseName;
        this.brief = brief;
        this.createDate = createDate;
    }
    public Book(String bookID, String bookTitle, String author, String brief, String publisher, String image, String content, String category) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.author = author;
        this.brief = brief;
        this.publisher = publisher;
        this.image = image;
        this.content = content;
        this.category = category;
    }

    public Book(String bookTitle, String author, String brief, String publisher, String image, String content, String category) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.brief = brief;
        this.publisher = publisher;
        this.image = image;
        this.content = content;
        this.category = category;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBookCaseID() {
        return bookCaseID;
    }

    public void setBookCaseID(int bookCaseID) {
        this.bookCaseID = bookCaseID;
    }

    public String getBookCaseName() {
        return bookCaseName;
    }

    public void setBookCaseName(String bookCaseName) {
        this.bookCaseName = bookCaseName;
    }

      public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Book{" + "bookID=" + bookID + ", bookTitle=" + bookTitle + ", author=" + author + ", brief=" + brief + ", publisher=" + publisher + ", image=" + image + ", content=" + content + ", category=" + category + ", bookCaseID=" + bookCaseID + ", bookCaseName=" + bookCaseName + '}';
    }

   
    
   
 
}
