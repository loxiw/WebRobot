/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adria
 */
public class GestorBBDDSessioRobot extends GestorSqlite {

    public GestorBBDDSessioRobot(String dbName) {
        super(dbName);
    }
    
    /**
     * Comprova si hi ha una sessió iniciada control·lant el robot
     * @return True si hi ha una sessió oberta, false si no n'hi ha cap
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Boolean comprovarDisponibilitat () throws ClassNotFoundException, SQLException {
        connection = obrirConnexio();
        statement = connection.createStatement();
        ResultSet result;
        String query = "SELECT disponible FROM sessio "
                     + "WHERE(`id` = 1"
                     + ");";
        result = statement.executeQuery(query);
        result.next();
        int resultat = result.getInt("disponible");
        if (resultat == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Obre una sessió de control del robot
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void obrirSessio () throws ClassNotFoundException, SQLException {
        String query = "UPDATE sessio "
                    +  "SET `disponible` = 0 "
                    +  "WHERE `id` = 1;";
        enviarUpdateQuery(query);
    }
    
    /**
     * Tanca una sessió de control del robot
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void tancarSessio () throws ClassNotFoundException, SQLException {
        String query = "UPDATE sessio "
                    +  "SET `disponible` = 1 "
                    +  "WHERE `id` = 1;";
        enviarUpdateQuery(query);
    }
}