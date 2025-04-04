package org.example.Products;

import java.time.LocalDate;

public class Expiring extends Product{
    private LocalDate expirationDate;
public Expiring(String name, double price, int quantity,LocalDate expirationDate){
    super(name,price,quantity);
    this.expirationDate=expirationDate;
}
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

}
