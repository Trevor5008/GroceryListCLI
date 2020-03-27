package io.trevor;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    /**We instantiate the GroceryList class, in order to access both the
     * ArrayList (groceries) and the multiple methods w/in...
     */
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addGroceryItem();
                    break;
                case 3:
                    modifyList();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    findItem();
                    break;
                case 6:
                    printInstructions();
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nMenu Options: ");
        System.out.println("\t 0 - To quit the application");
        System.out.println("\t 1 - To display items in your current list");
        System.out.println("\t 2 - To add an item to your list");
        System.out.println("\t 3 - To modify and item in your list");
        System.out.println("\t 4 - To remove an item from your list");
        System.out.println("\t 5 - To search for an item");
        System.out.println("\t 6 - To display menu options\n");
    }

    public static void addGroceryItem() {
        System.out.print("Enter an item to add: ");
        String item = scanner.nextLine();
        if(!groceryList.onFile(item)) {
            groceryList.addGroceryItem(item);
            System.out.println(item + ", has been added to your list\n");
        } else {
            System.out.println(item + ", is already in your list");
        }
    }

    public static void modifyList() {
        boolean quit = false;
        while(!quit) {
            System.out.print("Enter an item you want to replace ('q' to quit): ");
            String item = scanner.nextLine();
            if(item.equalsIgnoreCase("q")) { quit = true; }
            else if (groceryList.onFile(item)) {
                System.out.print("Enter the new item: ");
                String newItem = scanner.nextLine();
                groceryList.modifyList(item, newItem);
                System.out.println("\n" + item + " has been replaced with: " + newItem + "\n");
                quit = true;
            } else {
                System.out.println(item + ", is not in your current list");
            }
        }
    }

    public static void removeItem() {
        System.out.print("Enter an item you'd like to remove: ");
        String item = scanner.nextLine();
        if(groceryList.onFile(item)) {
            groceryList.removeItem(item);
            System.out.println("\n" + item + " has been removed\n");
        } else {
            System.out.println("\n"+item+" is not currently in your items");
        }
    }

    public static void findItem() {
        System.out.print("Enter an item to search for: ");
        String item = scanner.nextLine();
        boolean exists = groceryList.onFile(item);
        if(exists) {
            System.out.println("\nFound "+item+", in your list");
        } else {
            System.out.println("\n"+item+" is not currently in your items");
        }
    }
}


