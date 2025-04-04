package org.example.Cart;

import org.example.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Quantity is not available!");
            return;
        }
        if (product.isExpired()) {
            System.out.println("Cannot add expired product!");
            return;
        }
        items.add(new CartItem(product, quantity));
    }

    public double calcSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }
}




