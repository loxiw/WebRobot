/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import beans.Usuari;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.GestorBBDDSessioRobot;
import models.GestorBBDDUsuaris;

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String tipus = request.getParameter("tipus");
        
        if (tipus.equals("login")) {
            GestorBBDDUsuaris gestorUsuaris = new GestorBBDDUsuaris("C:/Users/Adria/Documents/GitHub/WebRobot/WebRobot/src/java/robot.sqlite");
            String nom = request.getParameter("nom");
            String contrasenya = request.getParameter("password");
            Usuari usuari = new Usuari(nom, contrasenya);
            Boolean loginCorrecte = gestorUsuaris.comprovarLogin(usuari);
            gestorUsuaris.tancarQuery();
            if (loginCorrecte) {
                GestorBBDDSessioRobot gestorSessio = new GestorBBDDSessioRobot("C:/Users/Adria/Documents/GitHub/WebRobot/WebRobot/src/java/robot.sqlite");
                Boolean robotDisponible = gestorSessio.comprovarDisponibilitat();
                gestorSessio.tancarQuery();
                if (robotDisponible) {
                    gestorSessio.obrirSessio();
                    String control = request.getParameter("control");
                    if (control.equals("fletxes")) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("controlFletxes.jsp");
                        dispatcher.forward(request, response);
                        response.sendRedirect("controlFletxes.jsp");
                    } else {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("controlRatoli.jsp");
                        dispatcher.forward(request, response);
                        response.sendRedirect("controlRatoli.jsp");
                    }
                    
                } else {
                    request.setAttribute("robotOcupat", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                    response.sendRedirect("index.jsp");
                }
            } else {             
                Boolean errorLogin = gestorUsuaris.comprovarUsuariExistent(usuari);
                gestorUsuaris.tancarQuery();
                if (errorLogin == true) {
                    usuari.setContrasenya("");
                    request.setAttribute("passwordIncorrecte", true);
                } else if (errorLogin == false) {
                    usuari.setNom("");
                    usuari.setContrasenya("");
                    request.setAttribute("nomUsuariIncorrecte", true);
                }
                request.setAttribute("usuari", usuari);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                response.sendRedirect("index.jsp");
            }
        } else if (tipus.equals("registre")) {
            GestorBBDDUsuaris gestorUsuaris = new GestorBBDDUsuaris("C:/Users/Adria/Documents/GitHub/WebRobot/WebRobot/src/java/robot.sqlite");
            String nom = request.getParameter("nom");
            String contrasenya = request.getParameter("password");
            Usuari usuari = new Usuari(nom, contrasenya);
            Boolean nomUsuariExistent = gestorUsuaris.comprovarUsuariExistent(usuari);
            gestorUsuaris.tancarQuery();
            if (!nomUsuariExistent) {
                gestorUsuaris.afegirNouUsuari(usuari);
                request.setAttribute("usuariCreat", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("usuariExistent", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
                dispatcher.forward(request, response);
                response.sendRedirect("register.jsp");
            }
                
        } else if (tipus.equals("logout")) {
            GestorBBDDSessioRobot gestorSessio = new GestorBBDDSessioRobot("C:/Users/Adria/Documents/GitHub/WebRobot/WebRobot/src/java/robot.sqlite");
            gestorSessio.tancarSessio();
            response.sendRedirect("index.jsp");
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
