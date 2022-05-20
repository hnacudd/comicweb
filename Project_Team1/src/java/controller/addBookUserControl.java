/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import dal.UserDAO;
import entity.*;
import java.io.IOException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class addBookUserControl extends HttpServlet {

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
            HttpSession session = request.getSession();
            UserDAO ud = new UserDAO();
            String user = (String) session.getAttribute("user");
            User u = ud.getUserByName(user);
            
            String bookID = request.getParameter("bid");
            if ((u != null) && (bookID != null)) {
                BookDAO dao = new BookDAO();
                List<Book> listBook = dao.getBookFromBookcaseByUser(u.getUserId());
                for (Book book : listBook) {
                    if(book.getBookID().equalsIgnoreCase(bookID)){
                        System.out.println("bookID exist: "+book.getBookID());
                        
                        response.sendRedirect("detail?bid=" + bookID+"&bookexist="+"Book is exist in BookCase!");
                        return;
                    }
                }
                String bookcaseID = (u.getBookCaseId() + "").trim();
                dao.addBookToBookCase(bookID, bookcaseID);
                request.setAttribute("addBooksuccess", "Add book to bookcase successful.");
                
                response.sendRedirect("detail?bid=" + bookID+"&addBooksuccess="+"Add book to bookcase successful.");
            } else {
                
                request.getRequestDispatcher("LoginController").forward(request, response);
            }
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
