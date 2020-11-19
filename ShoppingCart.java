package com.company;


import java.util.ArrayList;

public class ShoppingCart {
    private String customerName;
    private ArrayList<Aisle> aisles;
    private ArrayList<Aisle> cart;
    private ArrayList<Integer> qty;
    private ArrayList<Integer> prices;
    private int totalPrice;

    public ShoppingCart(String customerName) {
        this.customerName = customerName;
        this.aisles = new ArrayList<Aisle>();
        this.cart = new ArrayList<Aisle>();
        this.qty = new ArrayList<Integer>();
        this.prices = new ArrayList<Integer>();
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void createAisle() {
        for (ItemList items: ItemList.values()){
            this.aisles.add(new Aisle(items));
        }
    }

    public void addToChart(Aisle addItem, int qty){
        this.qty.add(qty);
        this.cart.add(addItem);
    }

    public void showMyCart(){
        int counter = 0;
        while (counter < this.qty.size()) {
            System.out.print((counter+1)+" - "+this.qty.get(counter) + " of " + this.cart.get(counter) + "\n");
            counter++;
        }

    }

    public Aisle getAisles(int i) {
        return this.aisles.get(i);
    }

    public void showAisle(){
        int counter = 0;
        int fruitStart = 5;
        int snackStart = 10;
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Dairy Product:");
        while (counter < 15) {
            for (Aisle item : this.aisles) {
                System.out.print(counter+1 +"."+ item + "  ");
                counter++;
                if (counter == fruitStart) System.out.println("\nFruit Stall:");
                if (counter == snackStart) System.out.println("\nSnack Bar:");
            }
        }
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    public ArrayList<Integer> calculatePrice(){
        int counter = 0;
        for (Aisle item : this.cart){
            switch (item.getItems()){
                case FRESH_MILK: this.prices.add(20000*this.qty.get(counter)); break;
                case YOGURT: this.prices.add(8000*this.qty.get(counter)); break;
                case CHEESE: this.prices.add(12000*this.qty.get(counter)); break;
                case BUTTER: this.prices.add(25000*this.qty.get(counter)); break;
                case FULL_CREAM_MILK: this.prices.add(18000*this.qty.get(counter)); break;
                case APPLE: this.prices.add(6000*this.qty.get(counter)); break;
                case CHERRY: this.prices.add(5000*this.qty.get(counter)); break;
                case STRAWBERRY: this.prices.add(5000*this.qty.get(counter)); break;
                case WATAMELON: this.prices.add(15000*this.qty.get(counter)); break;
                case MANGO: this.prices.add(7000*this.qty.get(counter)); break;
                case CHOCOBAR: this.prices.add(2000*this.qty.get(counter)); break;
                case KITKAT: this.prices.add(6000*this.qty.get(counter)); break;
                case CHIPS: this.prices.add(9000*this.qty.get(counter)); break;
                case CANDY: this.prices.add(2000*this.qty.get(counter)); break;
                case WAFER: this.prices.add(1500*this.qty.get(counter)); break;
            }
            counter++;
        }
        for (int price: this.prices){
            this.totalPrice += price;
        }
        return this.prices;
    }

    public int getTotalPrice(){
        return this.totalPrice;
    }

    public ArrayList<Aisle> getAisles() {
        return aisles;
    }

    public ArrayList<Aisle> getCart() {
        return cart;
    }

    public void removeFromCart(int removeIndex){
        this.cart.remove(removeIndex);
        this.qty.remove(removeIndex);
    }
}


class Aisle {
    private ItemList items;

    public Aisle(ItemList items) {
        this.items = items;
    }

    public ItemList getItems() {
        return items;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
