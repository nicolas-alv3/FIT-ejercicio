package com.fit.exercise.persistence;

import com.fit.exercise.model.ShoppingCart;
import com.fit.exercise.persistence.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartDAO {
    @Autowired
    private CartRepository cartRepository;
    public ShoppingCart save(ShoppingCart cart) {
        return cartRepository.save(cart);
    }
}
