package com.fit.exercise.model.SellCase;

import com.fit.exercise.model.ShoppingCart;

public class FourProductsCase extends SellCase {
    @Override
    public boolean canHandle(ShoppingCart cart) {
        return cart.getAmountOfProducts() == 4;
    }

    @Override
    public Double calculate(ShoppingCart cart) {
        return cart.getPriceWithoutDiscount() * 0.75;
    }
}
