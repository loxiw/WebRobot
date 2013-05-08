/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import beans.Usuari;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adria
 */
public class GestorSqlite {
    
    private Connection connection; 
    private Statement statement;
    private String dbName;
    
    public GestorSqlite(String dbName) {
        this.dbName = dbName;
    }
    
    /**
     * Obre una connexió a una SQLite
     * @param dbName Nom de la DB
     * @return DB sol·licitada
     * @throws UnknownHostException 
     */
    private Connection obrirConnexio () throws ClassNotFoundException, SQLException {
        String nomDriver = "org.sqlite.JDBC";
        String jdbc = "jdbc:sqlite";
        Class.forName(nomDriver);
        String urlJDBC = jdbc + ":" + dbName;
        connection = DriverManager.getConnection(urlJDBC);
        return connection;
    }
    
    /**
     * Tanca la connexió a la SQLite que li indiquem a connexio
     * @param connection Nom de la DB
     */
    private void tancarConnexio (Connection connection) throws SQLException {
        connection.close();
    }
    
    /**
     * Executa la UpdateQuery que volguem
     * @param query UpdateQuery que volguem executar
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void enviarUpdateQuery (String query) throws ClassNotFoundException, SQLException {
        connection = obrirConnexio();
        statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        tancarConnexio(connection);
    }
    
    /**
     * Inserta l'usuari que li passem a la BBDD
     * @param usuari Usuari a afegir
     */
    public void afegirNouUsuari (Usuari usuari) throws ClassNotFoundException, SQLException {
        connection = obrirConnexio();
        statement = connection.createStatement();
        String query = "INSERT INTO usuari VALUES('"
                     + usuari.getNom() + "', '"
                     + usuari.getContrasenya() + "'"
                     + ");";
        statement.executeUpdate(query);
        statement.close();
        tancarConnexio(connection);
    }
    
    /**
     * Li passem una query i ens retorna un ResultSet amb el resultat.
     * DESPRÉS CAL TANCAR LA CONNEXIÓ AMB tancarQuery()
     * @param query Query que volguem fer
     * @return Resposta de la query
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public ResultSet enviarQuery (String query) throws ClassNotFoundException, SQLException {
        connection = obrirConnexio();
        statement = connection.createStatement();
        ResultSet result;
        result = statement.executeQuery(query);
        return result;
    }
    
    /**
     * Rep un usuari i la seva password per paràmetres i retorna si existeix a la BBDD
     * @param usuari Usuari a comprobar
     * @return True si l'usuari existeix, false si no existeix
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Boolean comprobarLogin (Usuari usuari) throws ClassNotFoundException, SQLException {
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
     * Comprova on està l'error del login, si al nom d'usuari o al password
     * @param usuari Usuari a comprovar
     * @return True si l'error és de la contrasenya, false si es del nom d'usuari
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Boolean comprovarErrorLogin (Usuari usuari) throws ClassNotFoundException, SQLException {
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
    
    /**
     * Tanca la query anterior
     * @throws SQLException 
     */
    public void tancarQuery () throws SQLException {
        statement.close();
        tancarConnexio(connection);
    }
    
    /**
     * Retorna la metadata de la SQLite
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public DatabaseMetaData agafarMetaData () throws SQLException, ClassNotFoundException {
        connection = obrirConnexio();
        DatabaseMetaData metadata = connection.getMetaData();
        tancarConnexio(connection);
        return metadata;
    }
    
    /**
     * Retorna la metadata del ResultSet que li passem
     * @param result ResultSet que volem llegir
     * @return La metadata del ResultSet
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ResultSetMetaData agafarMetaDataDeResultSet (ResultSet result) throws SQLException, ClassNotFoundException {
        ResultSetMetaData rsm = result.getMetaData();
        return rsm;
    }

}