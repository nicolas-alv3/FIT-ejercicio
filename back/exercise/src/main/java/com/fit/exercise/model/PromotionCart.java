package com.fit.exercise.model;

import javax.persistence.Entity;

@Entity
public class PromotionCart extends ShoppingCart {

    public PromotionCart(Client client) {
        super(client);
    }

    public PromotionCart() {
        
    }
}
