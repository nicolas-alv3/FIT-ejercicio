package com.fit.exercise.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart  extends EntityId{
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    protected List<Product> products;
    private LocalDate date;
    @ManyToOne(cascade= CascadeType.ALL)
    private Client owner;

    public ShoppingCart(Client owner){
        this.owner = owner;
        this.date = LocalDate.now();
        products = new ArrayList<>();
    }

    public ShoppingCart() {
        this.date = LocalDate.now();
    }

    public ShoppingCart withDate(LocalDate newDate) {
        date = newDate;
        return this;
    }

    public Integer getAmountOfProducts() {
        return products.size();
    }

    public Double getPrice() {
        PriceCalculator priceCalculator = new PriceCalculator();
        //Sumatory of all unitPrices
        return priceCalculator.calculateWith(this);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double getPriceWithoutDiscount() {
        //Sumatory of all unitPrices
        return products.stream().map(Product::getPrice).reduce(0d,Double::sum);
    }

    public Double priceWithDiscountOfTenOrMore() {
        return getPriceWithoutDiscount();
    }

    public LocalDate getDate() {
        return date;
    }

    public Client getOwner() {
        return owner;
    }
}
