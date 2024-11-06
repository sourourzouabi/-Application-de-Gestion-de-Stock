package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TypeManager {
    private final Connection conn;

    public TypeManager(Connection connection) {
        this.conn = connection;
    }

    public void addType() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter type name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category ID: ");
        int categoryId = scanner.nextInt();

        try {
            String sql = "INSERT INTO Types (NomType, idCat) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, categoryId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Type added successfully.");
            } else {
                System.out.println("Failed to add type.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding type: " + e.getMessage());
        }
    }

    public void deleteType() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter type ID to delete: ");
        int typeId = scanner.nextInt();

        try {
            String sql = "DELETE FROM Types WHERE idType = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, typeId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Type deleted successfully.");
            } else {
                System.out.println("No type found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting type: " + e.getMessage());
        }
    }

    public void displayTypes() {
        try {
            String sql = "SELECT t.idType, t.NomType, c.NomCat FROM Types t JOIN categorie c ON t.idCat = c.idCat";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Types:");
            while (resultSet.next()) {
                int typeId = resultSet.getInt("t.idType");
                String typeName = resultSet.getString("t.NomType");
                String categoryName = resultSet.getString("c.NomCat");
                System.out.println(typeId + ": " + typeName + " (Category: " + categoryName + ")");
            }
        } catch (SQLException e) {
            System.out.println("Error displaying types: " + e.getMessage());
        }
    }

    public void updateType() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter type ID to update: ");
        int typeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new type name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter new category ID: ");
        int newCategoryId = scanner.nextInt();

        try {
            String sql = "UPDATE Types SET NomType = ?, idCat = ? WHERE idType = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setInt(2, newCategoryId);
            statement.setInt(3, typeId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Type updated successfully.");
            } else {
                System.out.println("No type found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating type: " + e.getMessage());
        }
    }
}
