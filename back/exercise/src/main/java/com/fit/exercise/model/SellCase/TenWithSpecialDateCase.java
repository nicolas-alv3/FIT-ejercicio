package com.fit.exercise.model.SellCase;

import com.fit.exercise.model.MyCalendar;
import com.fit.exercise.model.ShoppingCart;

public class TenWithSpecialDateCase extends SellCase{
    @Override
    public boolean canHandle(ShoppingCart cart) {
        return cart.getAmountOfProducts() >= 10 && new MyCalendar().isSpecialDate(cart.getDate());
    }

    @Override
    public Double calculate(ShoppingCart cart) {
        return cart.getPriceWithoutDiscount() - 300;
    }
}
