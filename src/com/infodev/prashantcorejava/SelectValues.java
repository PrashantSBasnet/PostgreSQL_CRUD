package com.infodev.prashantcorejava;

import java.sql.*;

public class SelectValues extends ExceptionHandling {

    public static void main(String[] args) {
        SelectValues example = new SelectValues();
        example.getUserById();
        example.getAllUsers();
    }

    private final String url = "jdbc:postgresql://localhost:5555/newdb";
    private final String user = "postgres";
    private final String password = "postgres";

    private static final String QUERY = "select id,name,email,country,password from users1 where id =?";
    private static final String SELECT_ALL_QUERY = "select * from users1";

    public void getUserById() {
        // using try-with-resources to avoid closing resources (boiler plate
        // code)

        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            ExceptionHandling.printSQLException(e);
        }
    }




    public void getAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate
        // code)

        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            ExceptionHandling.printSQLException(e);
        }
    }



}
