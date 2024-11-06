package db;

import java.util.Scanner;

public class Menu {
    private final CategoryManager categoryManager;
    private final TypeManager typeManager;
    private final ProductManager productManager;

    public Menu(CategoryManager categoryManager, TypeManager typeManager, ProductManager productManager) {
        this.categoryManager = categoryManager;
        this.typeManager = typeManager;
        this.productManager = productManager;
    }

    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Category Management");
            System.out.println("2. Type Management");
            System.out.println("3. Product Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> displayCategoryMenu();
                case 2 -> displayTypeMenu();
                case 3 -> displayProductMenu();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }

    private void displayCategoryMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Category Management Menu ---");
            System.out.println("1. Add Category");
            System.out.println("2. Delete Category");
            System.out.println("3. display Category");
            System.out.println("4. Update Category");

            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> categoryManager.addCategory();
                case 2 -> categoryManager.deleteCategory();
                case 3 -> categoryManager.displayCategories();
                case 4 -> categoryManager.updateCategory();
                case 5-> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        } while (choice != 5);
    }

    private void displayTypeMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Type Management Menu ---");
            System.out.println("1. Add Type");
            System.out.println("2. Delete Type");
            System.out.println("3. Display  Type");
            System.out.println("4. update Types");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> typeManager.addType();
                case 2 -> typeManager.deleteType();
                case 3->typeManager.displayTypes();
                case 4->typeManager.updateType();
                case 5-> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        } while (choice != 3);
    }

    private void displayProductMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Product Management Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. display all the  Product");
            System.out.println("4. update  Product");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> productManager.addProduct();
                case 2 -> productManager.deleteProduct();
                 case  3-> productManager.displayProducts();
                 case 4->productManager.updateProduct();
                case 5-> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        } while (choice != 3);
    }
}
