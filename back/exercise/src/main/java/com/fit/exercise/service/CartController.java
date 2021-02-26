package com.fit.exercise.service;

import com.fit.exercise.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Scope(value = "session")
@Component(value = "productController")
public class CartController {
    @Autowired
    private CartService cartService;


    @RequestMapping(method = RequestMethod.POST, value = "/cart")
    public ResponseEntity postCart(@RequestBody ShoppingCart cart){
        return new ResponseEntity(cartService.save(cart),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/simulateSell")
    public ResponseEntity simulateCart(@RequestBody SaleDTO saleDTO){
        return new ResponseEntity(cartService.simulateSale(saleDTO),HttpStatus.OK);
    }
}