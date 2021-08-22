package com.infodev.prashantcorejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create Table JDBC Example
 * @author prashant
 **/

public class CreateTableExample
{
    private final String url = "jdbc:postgresql://localhost:5555/newdb";
    private final String user = "postgres";
    private final String password = "postgres";

    private static final String createTableSQL = "CREATE TABLE users2" +
            "(ID INT PRIMARY KEY ," +
            " NAME TEXT, " +
            " EMAIL VARCHAR(50), " +
            " COUNTRY VARCHAR(50), " +
            " PASSWORD VARCHAR(50))";

    public static void main(String[] argv) throws SQLException {
        CreateTableExample createTableExample = new CreateTableExample();
        //createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);

             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);
        } catch (SQLException e) {

            // print SQL exception information
            ExceptionHandling.printSQLException(e);
        }
    }
}
