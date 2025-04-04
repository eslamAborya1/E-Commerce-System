package org.example;

import org.example.Products.*;
import org.example.Products.Product;
import org.example.Shipping.ShippableProduct;
import org.example.Shipping.Shipping;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Product cheese = new Expiring("Cheese", 10.0, 10, LocalDate.of(2025, 11, 10));
        Product tv = new ShippableProduct("TV", 5300.0, 5, 3000.0);
        Product scratchCard = new NonExpiring("Scratch Card", 5.0, 50);

        Customer customer = new Customer("Eslam", 10000.0);
        Shipping shipping = new Shipping(0.05);
        customer.addToCart(cheese, 2);
        customer.addToCart(tv, 1);
        customer.addToCart(scratchCard, 10);

        customer.checkout(shipping);
    }
}

