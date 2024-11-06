package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CategoryManager {
    private final Connection conn;

    public CategoryManager(Connection connection) {
        this.conn = connection;
    }

    public void addCategory() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter category name: ");
        String name = scanner.nextLine();

        try {
            String sql = "INSERT INTO categorie (NomCat) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Category added successfully.");
            } else {
                System.out.println("Failed to add category.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding category: " + e.getMessage());
        }
    }

    public void deleteCategory() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter category ID to delete: ");
        int categoryId = scanner.nextInt();

        try {
            String sql = "DELETE FROM categorie WHERE idCat = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, categoryId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Category deleted successfully.");
            } else {
                System.out.println("No category found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting category: " + e.getMessage());
        }
    }

    public void displayCategories() {
        try {
            String sql = "SELECT idCat, NomCat FROM categorie";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Categories:");
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("idCat");
                String categoryName = resultSet.getString("NomCat");
                System.out.println(categoryId + ": " + categoryName);
            }
        } catch (SQLException e) {
            System.out.println("Error displaying categories: " + e.getMessage());
        }
    }

    public void updateCategory() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter category ID to update: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new category name: ");
        String newName = scanner.nextLine();

        try {
            String sql = "UPDATE categorie SET NomCat = ? WHERE idCat = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setInt(2, categoryId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Category updated successfully.");
            } else {
                System.out.println("No category found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating category: " + e.getMessage());
        }
    }

    void menu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
