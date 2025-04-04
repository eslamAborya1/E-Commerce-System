package org.example.Products;

    public class NonExpiring extends Product {
        public NonExpiring(String name, double price, int quantity) {
            super(name, price, quantity);
        }

        @Override
        public boolean isExpired() {
            return false;
        }

}
