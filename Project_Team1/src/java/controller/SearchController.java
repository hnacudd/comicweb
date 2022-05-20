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
public class SearchController extends HttpServlet {

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
            out.println("<title>Servlet SearchController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchController at " + request.getContextPath() + "</h1>");
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
            BookDAO bd = new BookDAO();
            String bookTitleSearch = request.getParameter("titleBook");
            if(bookTitleSearch == null){
                request.setAttribute("errorMes", "Can't found.");
                request.getRequestDispatcher("displayTest.jsp").forward(request, response);
                return;
            }
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
                int count = bd.getTotalBookSearch(bookTitleSearch);
                int endPage = count / 10;
                if (count % 10 != 0) {
                    endPage++;
                }
                if (index > endPage) {
                    request.setAttribute("errorIndex", "This Page isn't exist");
                }
                List<Book> list = bd.searchBookByTitle(index, bookTitleSearch);
                request.setAttribute("listBookSearch", list);

                request.setAttribute("endP", endPage);
            }

            request.setAttribute("bookTitleSearch", bookTitleSearch);

            request.setAttribute("tag", index);
            request.getRequestDispatcher("Page_SearchResult.jsp").forward(request, response);
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
