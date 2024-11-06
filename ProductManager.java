package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;
public class ProductManager {
    private final Connection conn;

    public ProductManager(Connection connection) {
        this.conn = connection;
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter type ID: ");
        int typeId = scanner.nextInt();

        System.out.print("Enter category ID: ");
        int categoryId = scanner.nextInt();

        try {
            String sql = "INSERT INTO Products (NomProduct, IdType, IdCat) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, productName);
            statement.setInt(2, typeId);
            statement.setInt(3, categoryId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product added successfully.");
            } else {
                System.out.println("Failed to add product.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();

        try {
            String sql = "DELETE FROM products WHERE IdProduct = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, productId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No product found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }

    public void displayProducts() {
        try {
            String sql = "SELECT p.IdProduct, p.NomProduct, t.NomType, c.NomCat " +
                         "FROM Products p " +
                         "JOIN Types t ON p.IdType = t.IdType " +
                         "JOIN Categorie c ON p.IdCat = c.IdCat";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("product:");
            while (resultSet.next()) {
                int productId = resultSet.getInt("IdProduct");
                String productName = resultSet.getString("NomProduct");
                String typeName = resultSet.getString("NomType");
                String categoryName = resultSet.getString("NomCat");
                System.out.println(productId + ": " + productName + " (Type: " + typeName + ", Category: " + categoryName + ")");
            }
        } catch (SQLException e) {
            System.out.println("Error displaying products: " + e.getMessage());
        }
    }

    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new product name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter new type ID: ");
        int newTypeId = scanner.nextInt();

        System.out.print("Enter new category ID: ");
        int newCategoryId = scanner.nextInt();

        try {
            String sql = "UPDATE Products SET NomProduct = ?, IdType = ?, IdCat = ? WHERE IdProduct = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setInt(2, newTypeId);
            statement.setInt(3, newCategoryId);
            statement.setInt(4, productId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("No product found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }
}
