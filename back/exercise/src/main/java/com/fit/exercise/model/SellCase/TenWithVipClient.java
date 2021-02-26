package com.fit.exercise.model.SellCase;

import com.fit.exercise.model.ShoppingCart;

public class TenWithVipClient extends SellCase{
    @Override
    public boolean canHandle(ShoppingCart cart) {
        return cart.getOwner().isVIP();
    }

    @Override
    public Double calculate(ShoppingCart cart) {
        Double price = cart.getPriceWithoutDiscount();
        if( price > 4000)
            return price - 2000;
        return price;
    }
}
