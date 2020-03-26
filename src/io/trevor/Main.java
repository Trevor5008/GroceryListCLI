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
        System.out.println("\t 0 - To print the quit the application");
        System.out.println("\t 1 - To display items in your current list");
        System.out.println("\t 2 - To add an item to your list");
        System.out.println("\t 3 - To modify and item in your list");
        System.out.println("\t 4 - To remove an item from your list");
        System.out.println("\t 5 - To search for an item");
        System.out.println("\t 6 - To display menu options\n");
    }

    public static void addGroceryItem() {
        //TODO: Provide a conditional check before trying to add item, to make sure item doesn't
        // already exist...
        System.out.print("Enter an item to add: ");
        String item = scanner.nextLine();
        groceryList.addGroceryItem(item);
        System.out.println(item+", has been added to your list\n");
    }

    public static void modifyList() {
        //TODO: Adjust to accept a String input, instead of an int position
        System.out.print("Enter an item number you want to update: ");
        int position = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyList(position, newItem);
        System.out.println("\nItem #"+position+" has been updated\n");
    }

    public static void removeItem() {
        //TODO: Modify method to accept a String instead of an int position
        System.out.print("Enter an item number you'd like to remove: ");
        int position = scanner.nextInt();
        groceryList.removeItem(position);
        System.out.println("\nItem #"+position+", has been removed\n");
    }

    public static void findItem() {
        System.out.print("Enter an item to search for: ");
        String item = scanner.nextLine();
        boolean exists = groceryList.findItem(item);
        if(exists) {
            System.out.println("\nFound "+item+", in your list");
        } else {
            System.out.println("\n"+item+" is not currently in your items");
        }
    }
}


