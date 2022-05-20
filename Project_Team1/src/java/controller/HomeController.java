/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import entity.Book;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

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
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = 0;
            try {
                index = Integer.parseInt(indexPage);

            } catch (Exception e) {
                index = 0;
            }
            if (index < 1) {
                request.setAttribute("errorIndex", "This Page isn't exist");
            } else {
                
                int count = bd.getTotalBook();
                int endPage = count / 15;
                if (count % 15 != 0) {
                    endPage++;
                }
                if(index > endPage){
                    request.setAttribute("errorIndex", "This Page isn't exist");
                }
                List<Book> list = bd.pagingBook(index);
                request.setAttribute("listB", list);
                request.setAttribute("endP", endPage);
            }
           
            List<Book> list2 = bd.get5Book();
            
            request.setAttribute("list5B", list2);
            
            request.setAttribute("tag", index);
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception e) {
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
