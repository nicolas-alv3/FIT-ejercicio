package com.fit.exercise.model.SellCase;

import com.fit.exercise.model.ShoppingCart;

public class TenProductsCase extends SellCase{
    @Override
    public boolean canHandle(ShoppingCart cart) {
        return cart.getAmountOfProducts() >= 10;
    }

    @Override
    public Double calculate(ShoppingCart cart) {
        return cart.priceWithDiscountOfTenOrMore();
    }
}
