package com.fit.exercise.model.SellCase;

import com.fit.exercise.model.ShoppingCart;

public abstract class SellCase {
    public abstract boolean canHandle(ShoppingCart cart);

    public abstract Double calculate(ShoppingCart cart);
}
