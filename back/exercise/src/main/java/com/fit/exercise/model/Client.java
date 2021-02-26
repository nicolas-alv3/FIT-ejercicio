package com.fit.exercise.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends EntityId {
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="owner",orphanRemoval = true)

    private List<ShoppingCart> carts;

    public Client() {
        carts = new ArrayList<>();
    }

    public void addCart(ShoppingCart cart) {
        carts.add(cart);
    }

    public boolean isVIP() {
        return carts.stream()
                .filter( shoppingCart -> wasThisMonth(shoppingCart.getDate())) // Carts of this month
                .reduce(0d,(subtotal, cart) -> subtotal + cart.getPriceWithoutDiscount(), Double::sum) > 10000;
    }

    private boolean wasThisMonth(LocalDate date) {
        return LocalDate.now().getMonth().getValue() == date.getMonth().getValue();
    }
}
