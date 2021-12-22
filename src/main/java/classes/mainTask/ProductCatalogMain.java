package classes.mainTask;

import java.util.Scanner;

public class ProductCatalogMain {
    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product(1, "Apple", 1234567891234L, "BY", 2.99, 24, 100),
                new Product(2, "Orange", 1234567894321L, "IN", 3.99, 15, 150),
                new Product(3, "Tomato", 1234567893214L, "BY", 3.65, 20, 70),
                new Product(4, "Cucumber", 1234567895678L, "BY", 2.66, 15, 70),
                new Product(5, "Orange", 1234567894399L, "BR", 5.99, 15, 50),
                new Product(6, "Apple", 1234567894300L, "PL", 1.99, 30, 100),
                new Product(7, "Tomato", 1234567892599L, "PL", 3.99, 15, 55),
                new Product(8, "Chicken", 1234567894259L, "BR", 6.99, 10, 20),
                new Product(9, "Chicken", 1234567894258L, "PL", 6.25, 10, 100),
                new Product(10, "Carrot", 1234257892599L, "PL", 1.99, 25, 55),
                new Product(11, "Carrot", 1234257892599L, "RB", 2.20, 25, 20)
        };
        ProductCatalog productCatalog = new ProductCatalog(products);
        Scanner scanner = new Scanner(System.in);

        System.out.println("All products that we have:\n");
        productCatalog.printCatalog(productCatalog.getProducts());

        System.out.println("\nList of products with set name.");
        System.out.println("Input product name: ");
        String productName = scanner.nextLine();
        productCatalog.printCatalog(productCatalog.productListByName(productName));

        System.out.println("\nList of products with given product name and the price does not exceed set price:");
        System.out.println("Input product name: ");
        productName = scanner.nextLine();
        System.out.println("Input price: ");
        if (scanner.hasNextDouble()) {
            double setPrice = scanner.nextDouble();
            if (setPrice > 0)
            productCatalog.printCatalog(productCatalog.productCorrectPrice(productName, setPrice));
            else System.out.println("Incorrect input data!");
        } else System.out.println("Incorrect input data!");
        scanner.nextLine();

        System.out.println("\nList of products shelf life is longer than the set one:");
        System.out.println("Input self life: ");
        if (scanner.hasNextInt()){
            int setSelfLife = scanner.nextInt();
            if (setSelfLife > 0)
            productCatalog.printCatalog(productCatalog.productCorrectSelfLife(setSelfLife));
            else System.out.println("Incorrect input data!");
        } else System.out.println("Incorrect input data!");
    }
}
