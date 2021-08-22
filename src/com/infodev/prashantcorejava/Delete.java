package com.infodev.prashantcorejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends  ExceptionHandling{

    private static final String DELETE_USERS_SQL = "delete from users1 where id= 2;";
    private final String url = "jdbc:postgresql://localhost:5555/newdb";
    private final String user = "postgres";
    private final String password = "postgres";


    public static void main(String[] argv) throws SQLException {
        Delete deleteStatementExample = new Delete();
        deleteStatementExample.deleteRecord();
    }


    public void deleteRecord() throws SQLException {
        System.out.println(DELETE_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
             // preparedStatement.setInt(1, 1);
             // Step 3: Execute the query or update query
            int result = preparedStatement.executeUpdate();
            System.out.println("Number of records affected :: " + result);
        }

        catch (SQLException e) {

            // print SQL exception information
            ExceptionHandling.printSQLException(e);
        }
    }
}
