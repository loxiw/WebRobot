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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adria
 */
public class ServletUsuaris extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessio = request.getSession();
        String nom = request.getParameter("nom");
        String contrasenya = request.getParameter("password");
        Usuari usuari = new Usuari(nom, contrasenya);
        String tipus = request.getParameter("tipus");
        GestorSqlite gestor = new GestorSqlite("rutaDB");
        
        if (tipus.equals("login")) {
            Boolean loginCorrecte = gestor.comprobarLogin(usuari);
            gestor.tancarQuery();
            if (loginCorrecte) {
                response.sendRedirect("main.jsp");
            } else {
                Boolean errorLogin = gestor.comprobarErrorLogin(usuari);
                if (errorLogin == true) {
                    request.setAttribute("passwordIncorrecte", true);
                } else if (errorLogin == false) {
                    request.setAttribute("nomIncorrecte", true);
                }
                sessio.setAttribute("usuariBean", usuari);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
            
        } else if (tipus.equals("registre")) {
            try {
                gestor.afegirNouUsuari(usuari);
            } catch (SQLException ex) {
                Logger.getLogger(ServletUsuaris.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Usuari ja existent");
            }
        }
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
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
            Logger.getLogger(ServletUsuaris.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletUsuaris.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletUsuaris.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletUsuaris.class.getName()).log(Level.SEVERE, null, ex);
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
