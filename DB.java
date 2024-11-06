package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection conn = null;

    public static void main(String[] args) {
        conn = getConnection();
        if (conn == null) {
            System.out.println("Database connection failed. Exiting...");
            return;
        }

        try {
            CategoryManager categoryManager = new CategoryManager(conn);
            TypeManager typeManager = new TypeManager(conn);
            ProductManager productManager = new ProductManager(conn);

            Menu menu = new Menu(categoryManager, typeManager, productManager);
            menu.displayMainMenu();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to the database...");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}
