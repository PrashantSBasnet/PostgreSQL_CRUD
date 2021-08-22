package com.infodev.prashantcorejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update extends ExceptionHandling {

    private final String url = "jdbc:postgresql://localhost:5555/newdb";
    private final String user = "postgres";
    private final String password = "postgres";

    private static final String UPDATE_USERS_SQL = "update users1 set name = 'Prashant' where id = '6';";

    public static void main(String[] argv) throws SQLException {
        Update updateStatementExample = new Update();
        updateStatementExample.updateRecord();
    }

    public void updateRecord() throws SQLException {
        System.out.println(UPDATE_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            //preparedStatement.setString(1, "Ram");
            // preparedStatement.setInt(2, 1);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
}

