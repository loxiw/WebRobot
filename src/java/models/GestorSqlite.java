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
    
    protected Connection connection; 
    protected Statement statement;
    protected String dbName;
    
    public GestorSqlite(String dbName) {
        this.dbName = dbName;
    }
    
    /**
     * Obre una connexió a una SQLite
     * @param dbName Nom de la DB
     * @return DB sol·licitada
     * @throws UnknownHostException 
     */
    protected Connection obrirConnexio () throws ClassNotFoundException, SQLException {
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
    protected void tancarConnexio (Connection connection) throws SQLException {
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