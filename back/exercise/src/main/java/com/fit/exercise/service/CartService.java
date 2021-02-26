package com.fit.exercise.service;

import com.fit.exercise.model.Client;
import com.fit.exercise.model.RegularCart;
import com.fit.exercise.model.ShoppingCart;
import com.fit.exercise.persistence.CartDAO;
import com.fit.exercise.persistence.repository.ClientRepository;
import com.fit.exercise.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Scope(value = "session")
@Component(value = "cartService")
public class CartService {
    @Autowired
    private CartDAO cartDAO;
    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public ShoppingCart save(ShoppingCart cart) {
        return cartDAO.save(cart);
    }

    public ShoppingCart simulateSale(SaleDTO saleDTO) {
        Client client;
        if(clientRepository.existsById(saleDTO.clientID)){
            client = clientRepository.getOne(saleDTO.clientID);
        }else{
            client = new Client();
        }
        ShoppingCart cart =new RegularCart(client).withDate(saleDTO.date);
        saleDTO.products.stream().forEach(p -> cart.addProduct(p));
        return cart;
    }
}
