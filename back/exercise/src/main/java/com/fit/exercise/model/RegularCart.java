package com.fit.exercise.model;

public class RegularCart extends ShoppingCart {

    public RegularCart(Client client) {
        super(client);
    }

    public Double priceWithDiscountOfTenOrMore() {
        return Math.max(0,getPriceWithoutDiscount() - 100);
    }
}
