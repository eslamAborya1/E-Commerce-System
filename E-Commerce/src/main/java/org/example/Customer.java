package org.example;

import org.example.Cart.Cart;
import org.example.Cart.CartItem;
import org.example.Products.Product;
import org.example.Shipping.Shipping;

class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public void addToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
    }

    public void checkout(Shipping shipping) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        double subtotal = cart.calcSubtotal();
        double shippingFees = shipping.shippingFees(cart);
        double total = subtotal + shippingFees;

        if (balance < total) {
            System.out.println("Insufficient balance");
            return;
        }

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        balance -= total;
        shipping.printShippingNotice(cart);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFees);
        System.out.println("Total Paid: " + total);
        System.out.println("Remaining Balance: " + balance);
    }
}
