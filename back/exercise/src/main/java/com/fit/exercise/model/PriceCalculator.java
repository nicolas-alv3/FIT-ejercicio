package com.fit.exercise.model;

import com.fit.exercise.model.SellCase.*;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    List<SellCase> cases = new ArrayList();

    public PriceCalculator(){
        /* The order of the list matters */
        cases.add(new TenWithVipClient());
        cases.add(new TenWithSpecialDateCase());
        cases.add(new TenProductsCase());
        cases.add(new FourProductsCase());
        cases.add(new RegularCase());
    }
    public Double calculateWith(ShoppingCart cart) {
        return cases.stream().filter(c -> c.canHandle(cart)).findFirst().get().calculate(cart);
    }
}
