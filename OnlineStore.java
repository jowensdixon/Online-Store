package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class OnlineStore {
    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("---Welcome to the Inventory Management System---\n");

        while (true) {
            System.out.println("Please choose from the following options\n");
            System.out.println("What do you want to do?");
            System.out.println("\t1- List all products\n" +
                    "\t2- Lookup a product by its id\n" +
                    "\t3- Find all products within a price range\n" +
                    "\t4- Add a new product\n" +
                    "\t5- Quit the application\n");
            System.out.print("Enter Selection: ");
            int selection = keyboard.nextInt();
            keyboard.nextLine();

            switch (selection) {
                case 1:
                    Inventory(inventory);
                    System.out.print("Continue to menu (Hit Enter): ");
                    keyboard.nextLine();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option selected, please try again\n");
            }
        }
    }

    private static void Inventory(ArrayList<Product> inventory) {
        for (Product product : inventory) {
            System.out.println(product.toString());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/products.csv"));
            String line;

            // ✅ Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] splitItems = line.split(Pattern.quote("|"));
                inventory.add(new Product(
                        splitItems[0],                        // SKU
                        splitItems[1],                        // Product Name
                        Double.parseDouble(splitItems[2]),    // Price
                        splitItems[3]                         // Department
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventory;
    }
}
