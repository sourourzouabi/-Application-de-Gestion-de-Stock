package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            CategoryManager categoryManager = new CategoryManager(connection);
            TypeManager typeManager = new TypeManager(connection);
            ProductManager productManager = new ProductManager(connection);

            Menu menu = new Menu(categoryManager, typeManager, productManager);
            menu.displayMainMenu();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}