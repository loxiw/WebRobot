/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import beans.Usuari;
import models.GestorSqlite;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adria
 */

@WebServlet(name = "ServletUsuari", urlPatterns = {"/ServletUsuari"})

public class ServletUsuari extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessio = request.getSession();
        String nom = request.getParameter("nom");
        String contrasenya = request.getParameter("password");
        Usuari usuari = new Usuari(nom, contrasenya);
        String tipus = request.getParameter("tipus");
        GestorSqlite gestor = new GestorSqlite("C:/Users/Adria/Documents/GitHub/WebRobot/WebRobot/src/java/robot.sqlite");
        
        if (tipus.equals("login")) {
            try {
                Boolean correcte = gestor.comprobarLogin(usuari);
                gestor.tancarQuery();
                if (correcte) {
                    response.sendRedirect("main.jsp");
                } else {
                    Boolean errorLogin = gestor.comprovarErrorLogin(usuari);
                    if (errorLogin == true) {
                        request.setAttribute("passwordIncorrecte", true);
                    } else if (errorLogin == false) {
                        request.setAttribute("nomUsuariIncorrecte", true);
                    }
                    sessio.setAttribute("usuari", usuari);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                    response.sendRedirect("index.jsp");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ServletUsuari.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (tipus.equals("registre")) {
            try {
                gestor.afegirNouUsuari(usuari);
                request.setAttribute("usuariCreat", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                response.sendRedirect("index.jsp");
            } catch (SQLException ex) {
                request.setAttribute("usuariExistent", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                response.sendRedirect("index.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUsuari.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUsuari.class.getName()).log(Level.SEVERE, null, ex);
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
