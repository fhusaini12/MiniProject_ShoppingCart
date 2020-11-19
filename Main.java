package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        ShoppingCart customer1;
        int customerChoice;
        int customerPayment;
        int customerChange;
        int itemChoice;
        int itemQty;

        System.out.println("Welcome to The Supermarker");
        System.out.print("Welcome, please tell me your name so I can call you properly: ");
        String myName = scanner1.nextLine();
        customer1 = new ShoppingCart(myName);
        customer1.createAisle();
        System.out.print("How can I help you? (1:Come in and Buy, 2:Leave): ");
        int firstAnswer = scanner.nextInt();
        boolean isBuying = (firstAnswer==1);
        while (isBuying) {
            System.out.println("Hello, "+customer1.getCustomerName()+". What do you want to do?");
            System.out.print("(1:Buy, 2:Remove From Cart, 3:Show Cart, 4:Pay, 5:Leave): ");
            customerChoice = scanner.nextInt();
            if (customerChoice == 1){
                customer1.showAisle();
                System.out.print("What do you want to buy?\n(Please select the item number): ");
                itemChoice = scanner1.nextInt();
                while(itemChoice > customer1.getAisles().size() || itemChoice < 1){
                    customer1.showAisle();
                    System.out.println("I'm sorry, We don't have that item\n(Please select within the item number): ");
                    itemChoice = scanner.nextInt();
                }
                System.out.print("How much you want to buy?: ");
                itemQty = scanner.nextInt();
                customer1.addToChart(customer1.getAisles(itemChoice - 1), itemQty);
                System.out.println("Thank you...");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
            } else if(customerChoice == 2 && customer1.getCart().size() != 0){
                customer1.showMyCart();
                System.out.print("Which item you want to remove?\n(Please select the item number): ");
                itemChoice = scanner1.nextInt();
                while (itemChoice < 1 || itemChoice > customer1.getCart().size()){
                    System.out.println("I'm sorry, you don't have that item\n(Please select the item number): ");
                    itemChoice = scanner.nextInt();
                }
                System.out.println("Removing....");
                customer1.removeFromCart(itemChoice - 1);
                System.out.println("Remove complete");
            } else if(customerChoice == 2 && customer1.getCart().size() == 0){
                System.out.println("I'm sorry, your cart is empty");
            } else if(customerChoice == 3){
                System.out.println("Here is your Shopping Cart");
                customer1.showMyCart();
            } else if(customerChoice == 4 && customer1.getCart().size() != 0){
                System.out.println("Processing your cart....");
                customer1.calculatePrice();
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println("Here's your items");
                customer1.showMyCart();
                System.out.println("Your total payment is: Rp." + customer1.getTotalPrice());
                System.out.print("Pay here: ");
                customerPayment = scanner.nextInt();
                while (customerPayment < customer1.getTotalPrice()){
                    System.out.println("I'm sorry, your payment is not enough (Rp." + customer1.getTotalPrice()+")");
                    System.out.print("Pay here: ");
                    customerPayment = scanner.nextInt();
                }
                System.out.println("Processing your payment.....");
                customerChange = customerPayment - customer1.getTotalPrice();
                System.out.println("Thank you Mr/Mrs " + customer1.getCustomerName());
                System.out.println("Here is your change: " + customerChange);
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
                isBuying = false;
            } else if(customerChoice == 4 && customer1.getCart().size() == 0){
                System.out.println("I'm sorry, your cart is empty");
            } else if(customerChoice == 5){
                isBuying = false;
            }
        }
        System.out.println("Thank you for coming\nSee you next time!");
    }
}
