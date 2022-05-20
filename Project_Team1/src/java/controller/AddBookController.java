/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Book;

/**
 *
 * @author Dinh Tuan Minh
 */
public class AddBookController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddBookController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddBookController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("Page_AddBook.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Somthing wrong");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String author = request.getParameter("author");
            String bookTitle = request.getParameter("title");
            String brief = request.getParameter("brief");
            String publisher = request.getParameter("publisher");
            String content = request.getParameter("content");
            String category = request.getParameter("category");
            String image = request.getParameter("image");
            System.out.println(image);
            BookDAO bookDAO = new BookDAO();
            List<Book> listBook;
            listBook = bookDAO.getAllBook();
            boolean checkBookExits = false;
            System.out.println(author + bookTitle + brief + category + content + publisher);
            for (Book book : listBook) {
                if (bookTitle.equalsIgnoreCase(book.getBookTitle())) {
                    checkBookExits = true;
                    System.out.println("no");
                }
            }
            if (checkBookExits == false) {
                Book book = new Book(bookTitle, author, brief, publisher, image, content,category);
                bookDAO.addNewBook(book.getBookTitle(), book.getAuthor(), book.getBrief(), book.getPublisher(), book.getContent(), book.getCategory(), book.getImage());
                request.setAttribute("successAd", "Add successful");
                request.getRequestDispatcher("Page_AddBook.jsp").forward(request, response);
            } else {
                request.setAttribute("exitBook", "Book exited!");
                request.setAttribute("bookTitle", bookTitle);
                request.getRequestDispatcher("Page_AddBook.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
