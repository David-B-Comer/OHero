package models.utility;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemStash;


    public Inventory() {
        itemStash = new ArrayList<Item>();

    }

    public ArrayList<Item> getItemStash() {
        return itemStash;
    }

    public void setItemStash(ArrayList<Item> itemStash) {
        this.itemStash = itemStash;
    }
}
