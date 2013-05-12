/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Usuari;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adria
 */
public class GestorBBDDUsuaris extends GestorSqlite {

    public GestorBBDDUsuaris(String dbName) {
        super(dbName);
    }
    
    /**
     * Inserta l'usuari que li passem a la BBDD
     * @param usuari Usuari a afegir
     */
    public void afegirNouUsuari (Usuari usuari) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO usuari VALUES('"
                     + usuari.getNom() + "', '"
                     + usuari.getContrasenya() + "'"
                     + ");";
        enviarUpdateQuery(query);
    }
    
        /**
     * Rep un usuari i la seva password per paràmetres i retorna si existeix a la BBDD
     * @param usuari Usuari a comprobar
     * @return True si l'usuari existeix, false si no existeix
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Boolean comprovarLogin (Usuari usuari) throws ClassNotFoundException, SQLException {
        connection = obrirConnexio();
        statement = connection.createStatement();
        ResultSet result;
        String query = "SELECT COUNT(*) FROM usuari "
                     + "WHERE(`nom` = '"
                     + usuari.getNom() + "' "
                     + "AND `password` = '"
                     + usuari.getContrasenya() + "'"
                     + ");";
        result = statement.executeQuery(query);
        result.next();
        int rows = result.getInt("COUNT(*)");
        if (rows == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Comprova si el nom de l'usuari introduït es trova a la BBDD
     * @param usuari Usuari a comprovar
     * @return True si hi és, false si no
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Boolean comprovarUsuariExistent (Usuari usuari) throws ClassNotFoundException, SQLException {
        connection = obrirConnexio();
        statement = connection.createStatement();
        ResultSet result;
        String query = "SELECT COUNT(*) FROM usuari "
                     + "WHERE(`nom` = '"
                     + usuari.getNom() + "'"
                     + ");";
        result = statement.executeQuery(query);
        result.next();
        int rows = result.getInt("COUNT(*)");
        if (rows == 1) {
            return true;
        } else {
            return false;
        }
    }
    
}
