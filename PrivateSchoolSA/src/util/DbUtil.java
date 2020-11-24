package util;

import java.sql.*;

public class DbUtil {

    private static Connection connection = null;
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/privateschool";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception e) {

            e.printStackTrace();
        }
        return connection;
    }
}
