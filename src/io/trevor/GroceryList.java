package io.trevor;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceries = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceries.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have "+ groceries.size() + " items in your grocery list");
        for(int i = 0; i < groceries.size(); i++) {
            System.out.println("\t"+(i+1)+". "+groceries.get(i));
        }
        System.out.println();
    }
    public void modifyList(int position, String newItem) {
        groceries.set(position-1, newItem);
    }
    public void removeItem(int position) {
        String item = groceries.get(position-1);
        groceries.remove(item);
    }
    public boolean findItem(String item) {
        int position = groceries.indexOf(item);
        if(position >= 0) {
            return true;
        }
        return false;
    }
}
