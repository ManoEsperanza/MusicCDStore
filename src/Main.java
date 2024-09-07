import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> productList = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        do {
            int choice = displayMenu();
            if (choice == 1) {
                addNewProduct();
            } else if (choice == 2) {
                displayProducts(productList);
            } else if (choice == 3) {
                break;
            }

        } while (true);
        {
            Product product = new Product("CD", 19.99, "S123456");
            PhysicalProduct physicalProduct = new PhysicalProduct("", 29.99, "789012", "XL", 0.5, "Blue");

            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Price: $" + product.getPrice());
            System.out.println("Product SKU: " + product.getSku());

            System.out.println("Physical Product Name: " + physicalProduct.getName());
            System.out.println("Physical Product Price: $" + physicalProduct.getPrice());
            System.out.println("Physical Product SKU: " + physicalProduct.getSku());
            System.out.println("Physical Product Size: " + physicalProduct.getSize());
            System.out.println("Physical Product Weight: " + physicalProduct.getWeight() + " lbs");
            System.out.println("Physical Product Color: " + physicalProduct.getColor());
        }
//        {
//            Product product = new Product("Book", 19.99, "123456");
//            PhysicalProduct physicalProduct = new PhysicalProduct("T-shirt", 29.99, "789012", "XL", 0.5, "Blue");
//            DigitalProduct digitalProduct = new DigitalProduct("E-book", 9.99, "345678", "PDF", "<https://example.com/ebook>");
//
//            System.out.println("Product Name: " + product.getName());
//            System.out.println("Product Price: $" + product.getPrice());
//            System.out.println("Product SKU: " + product.getSku());
//
//            System.out.println("Physical Product Name: " + physicalProduct.getName());
//            System.out.println("Physical Product Price: $" + physicalProduct.getPrice());
//            System.out.println("Physical Product SKU: " + physicalProduct.getSku());
//            System.out.println("Physical Product Size: " + physicalProduct.getSize());
//            System.out.println("Physical Product Weight: " + physicalProduct.getWeight() + " lbs");
//            System.out.println("Physical Product Color: " + physicalProduct.getColor());
//
//            System.out.println("Digital Product Name: " + digitalProduct.getName());
//            System.out.println("Digital Product Price: $" + digitalProduct.getPrice());
//            System.out.println("Digital Product SKU: " + digitalProduct.getSku());
//            System.out.println("Digital Product Format: " + digitalProduct.getFormat());
//            System.out.println("Digital Product Download Link: " + digitalProduct.getDownloadLink());
//        }
    }

    private static int displayMenu() {

        int choice = 0;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a product");
            System.out.println("2. List all products");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            // consume the newline character
            scanner.nextLine(); // Consume the newline character after scanner.nextInt()
            if (choice >= 1 && choice <= 3) {
                break;
            }
        }

        return choice;

    }

    private static void addNewProduct() {
        System.out.println("Enter the name of the product: ");
        String name = scanner.nextLine();
        System.out.println("Enter the price of the product: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume the newline character remaining in the buffer
        System.out.println("Enter the SKU of the product: ");
        String sku = scanner.nextLine();

        while(true) {
            System.out.println("Choose the type of product: ");
            System.out.println("1. Physical Product");
            System.out.println("2. Digital Product");
            int choice = scanner.nextInt();

            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter the size of the physical product: ");
                String size = scanner.nextLine();
                System.out.println("Enter the weight of the physical product: ");
                double weight = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character remaining in the buffer
                System.out.println("Enter the color of the physical product: ");
                String color = scanner.nextLine();

                PhysicalProduct physicalProduct = new PhysicalProduct(name, price, sku, size, weight, color);
                productList.add(physicalProduct);
                System.out.println("Physical product added successfully!");
                break;
            } else if (choice == 2) {
                System.out.println("Enter the format of the digital product: ");
                String format = scanner.nextLine();
                System.out.println("Enter the download link of the digital product: ");
                String downloadLink = scanner.nextLine();

                DigitalProduct digitalProduct = new DigitalProduct(name, price, sku, format, downloadLink);
                productList.add(digitalProduct);
                System.out.println("Digital product added successfully!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void displayProducts(ArrayList<Product> productList) {
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            // print out the index
            System.out.println("Product #" + i);
            p.displayDetails();
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Exit");
        System.out.println("2. Edit a product");
        System.out.println("3. Delete a product");
        int option = scanner.nextInt();

        if (option == 2) {
            System.out.print("Enter the index of the product you want to edit: ");
            int index = scanner.nextInt();
            if (index >= 0 && index < productList.size()) {
                Product productToEdit = productList.get(index);
                editProduct(productToEdit);
            } else {
                System.out.println("Invalid index.");
            }
        } else if (option == 3) {
            System.out.print("Enter the index of the product you want to delete: ");
            int index = scanner.nextInt();
            if (index >= 0 && index < productList.size()) {
                productList.remove(index);
                System.out.println("Product deleted.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }
    public static void editProduct(Product p) {
        p.editDetails();
    }

}



