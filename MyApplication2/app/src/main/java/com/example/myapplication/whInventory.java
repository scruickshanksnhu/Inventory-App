//Steven Cruickshank
//Project 3 - Inventory App
package com.example.myapplication;



public class whInventory {
    // variables
    private String itemName;
    private String itemDesc;
    private String itemStock;
    private int id;

    // getters and setters
    public String getItemName() { return itemName; }

    public void setItemName(String i)
    {
        this.itemName = i;
    }

    public String getItemDesc()
    {
        return itemDesc;
    }

    public void setItemDesc(String desc)
    {
        this.itemDesc = desc;
    }

    public String getItemStock()
    {
        return itemStock;
    }

    public void
    setItemStock(String i)
    {
        this.itemStock = i.toString();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }


    //wh inventory
    public whInventory(String itemName, String itemDesc, String amt)
    {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemStock = amt.toString();
    }
}

