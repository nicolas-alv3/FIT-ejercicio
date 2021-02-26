package com.fit.exercise.model.SellCase;

import com.fit.exercise.model.ShoppingCart;

public class RegularCase extends SellCase {

    @Override
    public boolean canHandle(ShoppingCart cart) {
        return true;
    }

    @Override
    public Double calculate(ShoppingCart cart) {
        return cart.getPriceWithoutDiscount();
    }
}
