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

import java.sql.SQLException;
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
public class detailControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String id = request.getParameter("bid");
            HttpSession session = request.getSession();
            
            BookDAO dao = new BookDAO();
            String alert = request.getParameter("bookexist");
            String success = request.getParameter("addBooksuccess");
            if(alert != null){
                request.setAttribute("bookexist", "Book is exist in BookCase!");
            }
            if(success!=null){
                request.setAttribute("addBooksuccess", "Add book to bookcase successful.");
            }
            
            Book b = dao.getBookByID(id);
            
            
            UserDAO ud = new UserDAO();
            
            if (b != null) {
                String user = (String) session.getAttribute("user");
                request.setAttribute("book", b);
                if (user == null) {

                    request.getRequestDispatcher("Page_Detail.jsp").forward(request, response);
                    return;
                }
                User u = ud.getUserByName(user);
                
                if (dao.checkBookInBookCase(id, (u.getBookCaseId() + "").trim()) == true) {
                    request.setAttribute("ownBook", 1);
                } else {
                    request.setAttribute("ownBook", 0);
                }
                request.getRequestDispatcher("Page_Detail.jsp").forward(request, response);
            } else {
                request.setAttribute("noBid", "Book isn't exist.");
                 request.getRequestDispatcher("Page_Detail.jsp").forward(request, response);
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
     * @throws java.sql.SQLException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(detailControl.class.getName()).log(Level.SEVERE, null, ex);
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
