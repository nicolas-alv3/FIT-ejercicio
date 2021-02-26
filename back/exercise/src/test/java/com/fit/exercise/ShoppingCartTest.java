package com.fit.exercise;

import com.fit.exercise.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ShoppingCartTest {

    private ShoppingCart promotionCart;
    private ShoppingCart regularCart;
    private Client aClient;

    @Before
    public void setup() {
        aClient = new Client();
        promotionCart = new PromotionCart(aClient);
        regularCart = new RegularCart(aClient);
    }
    @Test
    public void aShoppingCartStartsWithZeroProducts(){
        Assert.assertEquals(Integer.valueOf(0), promotionCart.getAmountOfProducts());
        Assert.assertEquals(Integer.valueOf(0), regularCart.getAmountOfProducts());
    }

    @Test
    public void aShoppingCartStartsWithZeroPrice(){
        Assert.assertEquals(Double.valueOf(0), promotionCart.getPrice());
        Assert.assertEquals(Double.valueOf(0), regularCart.getPrice());
    }

    @Test
    public void aShoppingCrtWithAProductWithPriceOf10HasPriceOf10(){
        promotionCart.addProduct(new Product("Manaos",10.0, "No description"));
        regularCart.addProduct(new Product("Manaos",10.0, "No description"));
        Assert.assertEquals(Double.valueOf(10), promotionCart.getPrice());
        Assert.assertEquals(Double.valueOf(10), regularCart.getPrice());
    }

    @Test
    public void aShoppingCartWithFourProductsOf10Has25PercentDiscount(){
        addProductsToCart(4,10d,promotionCart);
        addProductsToCart(4,10d,regularCart);

        Assert.assertEquals(Double.valueOf(30), promotionCart.getPrice());
        Assert.assertEquals(Double.valueOf(30), regularCart.getPrice());
    }

    @Test
    public void aRegularCartWithTenProductsOf100Has100ofDiscount(){
        addProductsToCart(10,100d,regularCart);

        Assert.assertEquals(Double.valueOf(900), regularCart.getPrice());
    }

    @Test
    public void aPromotionalCartWithTenProductsOf100HasNoDiscount(){
        addProductsToCart(10,100d,promotionCart);

        Assert.assertEquals(Double.valueOf(1000), promotionCart.getPrice());
    }

    @Test
    public void aPromotionalCartWithTenProductsInCHRISTMASHas300ofDiscount(){
        addProductsToCart(10,100d,promotionCart.withDate(LocalDate.of(2021,12,25)));

        Assert.assertEquals(Double.valueOf(700), promotionCart.getPrice());
    }

    @Test
    public void aPromotionalCartWith41ProductsOf100AndVIPClientHas2000ofDiscount(){
        // A client with a cart of 10100 pesos this month
        Client aVIPClient = aVIPClient();
        PromotionCart promotionCart = new PromotionCart(aVIPClient);

        // Add a new cart of 4100 pesos
        addProductsToCart(41,100d,promotionCart);
        aVIPClient.addCart(promotionCart);

        Assert.assertEquals(Double.valueOf(2100), promotionCart.getPrice());
    }

    @Test
    public void aPromotionalCartWith40ProductsOf100_NOT_VIP_ClientHasZEROofDiscount(){
        // A client with a cart of 10000 pesos this month
        Client aClient = new Client();
        PromotionCart promotionCart = new PromotionCart(aClient);

        // Add a new cart of 4100 pesos
        addProductsToCart(40,100d,promotionCart);
        aClient.addCart(promotionCart);

        Assert.assertEquals(Double.valueOf(4000), promotionCart.getPrice());
    }

    @Test
    public void aPromotionalCartWith39ProductsOf100AndVIPClientHas2000ofDiscount(){
        // A client with a cart of 10100 pesos this month
        Client aVIPClient = aVIPClient();
        PromotionCart promotionCart = new PromotionCart(aVIPClient);

        // Add a new cart of 3900 pesos
        addProductsToCart(39,100d,promotionCart);
        aVIPClient.addCart(promotionCart);

        Assert.assertEquals(Double.valueOf(3900), promotionCart.getPrice());
    }

    private Client aVIPClient() {
        Client client = new Client();
        PromotionCart newPromotionCart = new PromotionCart(client);
        addProductsToCart(11,1000d,newPromotionCart);
        client.addCart(newPromotionCart);
        return client;
    }

    private void addProductsToCart(int i, double price, ShoppingCart shCart) {
        for (int j = 0; j < i; j++) {
            shCart.addProduct(new Product("TestProduct",price, "No description"));
        }
    }

}
