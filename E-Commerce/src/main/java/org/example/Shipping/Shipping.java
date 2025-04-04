package org.example.Shipping;

import org.example.Cart.Cart;
import org.example.Cart.CartItem;

public class Shipping {

    private double pricePerUnitWeight;

    public Shipping(double pricePerUnitWeight) {
        this.pricePerUnitWeight = pricePerUnitWeight;
    }

    public double shippingFees(Cart cart) {
        double shippingFees = 0;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof Shippable) {
                shippingFees += ((Shippable) item.getProduct()).getWeight() * item.getQuantity() * pricePerUnitWeight;
            }
        }
        return shippingFees;
    }

    public void printShippingNotice(Cart cart) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof Shippable) {
                double weight = ((Shippable) item.getProduct()).getWeight() * item.getQuantity();
                totalWeight += weight;
                System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + weight + "g");
            }
        }
        System.out.println("Total package weight: " + (totalWeight / 1000) + "kg");
    }
}


