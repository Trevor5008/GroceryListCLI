package io.trevor;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceries = new ArrayList<>();
    
    /** Following methods assume item exists, which is
     * tested for in main class with 'onFile' method below
     * @param item = grocery item
     */
    public void addGroceryItem(String item) {
        groceries.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have "+ groceries.size() + " items in your grocery list");
        for(int i = 0; i < groceries.size(); i++) {
            System.out.println("\t"+(i+1)+". "+groceries.get(i));
        }
    }

    public void modifyList(String oldItem, String newItem) {
        int position = findItem(oldItem);
        groceries.set(position, newItem);
    }

    public void removeItem(String item) {
        int position = findItem(item);
        groceries.remove(position);
    }

    private int findItem(String item) {
        int position = groceries.indexOf(item);
        return position;
    }

    /** Utilized by Main class methods as
     * preliminary conditional check
     * @param item = the grocery item
     * @return 'true' if exists/'false' otherwise
     */
    public boolean onFile(String item) {
        int position = groceries.indexOf(item);
        if(position >= 0) {
            return true;
        }
        return false;
    }
}
