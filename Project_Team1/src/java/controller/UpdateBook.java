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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Book;

/**
 *
 * @author Dinh Tuan Minh
 */
public class UpdateBook extends HttpServlet {

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
            out.println("<title>Servlet UpdateBook</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateBook at " + request.getContextPath() + "</h1>");
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
            String bookID = request.getParameter("bookID");
            BookDAO bookDAO = new BookDAO();
            Book book = bookDAO.getBookByID(bookID);
            request.setAttribute("bookID",book.getBookID());
            request.setAttribute("author",book.getAuthor());
            request.setAttribute("title",book.getBookTitle());
            request.setAttribute("brief",book.getBrief());
            request.setAttribute("publisher",book.getPublisher());
            request.setAttribute("content",book.getContent());
            request.setAttribute("category",book.getCategory());
            request.setAttribute("image",book.getImage());
            System.out.println("hehe" + book.getImage());
            request.getRequestDispatcher("Page_UpdateBook.jsp").forward(request, response);
        } catch (Exception ex) {
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
            int bookID = Integer.parseInt(request.getParameter("bookID"));
            String author = request.getParameter("author");
            String bookTitle = request.getParameter("title");
            String brief = request.getParameter("brief");
            String publisher = request.getParameter("publisher");
            String content = request.getParameter("content");
            String category = request.getParameter("category");
            String image = request.getParameter("image");
            BookDAO bookDAO = new BookDAO();
//int bookid, String bookTitle, String author, String brief, String publisher, String image, String content, String category
            Book book = new Book(bookID, bookTitle, author, brief, publisher, image, content, category);

            bookDAO.updateBook(book.getBookid(), book.getBookTitle(), book.getAuthor(), book.getBrief(), book.getPublisher(), book.getContent(), book.getCategory(), book.getImage());
            request.setAttribute("success", "Update Success!.");
            request.setAttribute("bookID",bookID);
            request.setAttribute("author",author);
            request.setAttribute("title",bookTitle);
            request.setAttribute("brief",brief);
            request.setAttribute("publisher",publisher);
            request.setAttribute("content",content);
            request.setAttribute("category",category);
            request.setAttribute("image",image);
            request.getRequestDispatcher("Page_UpdateBook.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            Logger.getLogger(UpdateBook.class.getName()).log(Level.SEVERE, null, ex);
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
