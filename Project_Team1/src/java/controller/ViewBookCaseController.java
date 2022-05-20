/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import dal.UserDAO;
import entity.Book;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class ViewBookCaseController extends HttpServlet {

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
        try {
            BookDAO bd = new BookDAO();
            UserDAO ud = new UserDAO();
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("user");
            if (user == null) {

                request.setAttribute("emptyBookCase", "BookCase is Empty. Please login to view BookCase.");
                request.getRequestDispatcher("ViewBookCase.jsp").forward(request, response);
                return;
            }

            User u = ud.getUserByName(user);
            int userID = u.getUserId();
            int bookcaseID = u.getBookCaseId();

            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            //int index = Integer.parseInt(indexPage);
            int index = 0;
            try {
                index = Integer.parseInt(indexPage);

            } catch (Exception e) {
                index = 0;
            }
            if (index < 1) {
                request.setAttribute("errorIndex", "This Page isn't exist");
            } else {
                int count = bd.getTotalBookInBookCase(userID);
                int endPage = count / 5;
                if (count % 5 != 0) {
                    endPage++;
                }
                if(endPage < index){
                    request.setAttribute("errorIndex", "This Page isn't exist");
                }
                List<Book> list = bd.getBookFromBookcaseByUser(userID, index);
                request.setAttribute("bcID", bookcaseID);
                request.setAttribute("endP", endPage);
                request.setAttribute("listBookInBC", list);
            }

            request.setAttribute("tag", index);

            request.getRequestDispatcher("ViewBookCase.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Somthing wrong");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
