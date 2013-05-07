/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestors;


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

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
    
    /**
     * Obre una connexió a una SQLite
     * @param dbName Nom de la DB
     * @return DB sol·licitada
     * @throws UnknownHostException 
     */
    private Connection obrirConnexio (String dbName) throws ClassNotFoundException, SQLException {
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
        connection = obrirConnexio(dbName);
        statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        tancarConnexio(connection);
    }
    
    /**
     * Inserta l'usuari que li passem a la BBDD
     * @param nomUsuari Nom de l'usuari a afegir
     * @param passwordUsuari Password de l'usuari a afegir
     */
    public void afegirNouUsuari (String nomUsuari, String passwordUsuari) throws ClassNotFoundException, SQLException {
        connection = obrirConnexio(dbName);
        statement = connection.createStatement();
        String query = "INSERT INTO usuari VALUES('"
                     + nomUsuari + "', '"
                     + passwordUsuari + "'"
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
        connection = obrirConnexio(dbName);
        statement = connection.createStatement();
        ResultSet result;
        result = statement.executeQuery(query);
        return result;
    }
    
    /**
     * Rep un usuari i la seva password per paràmetres i retorna si existeix a la BBDD
     * @param usuari Usuari a comprobar
     * @param password Password a comprobar
     * @return True si l'usuari existeix, false si no existeix
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Boolean comprobarLogin (String usuari, String password) throws ClassNotFoundException, SQLException {
        connection = obrirConnexio(dbName);
        statement = connection.createStatement();
        ResultSet result;
        String query = "SELECT COUNT(*) FROM usuari "
                     + "WHERE(`nom` = 'oriol'"
                     + "AND `password` = '1234c'"
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
        connection = obrirConnexio(dbName);
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