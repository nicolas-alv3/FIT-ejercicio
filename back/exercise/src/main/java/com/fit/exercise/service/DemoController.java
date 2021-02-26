package com.fit.exercise.service;

import com.fit.exercise.model.ShoppingCart;
import com.fit.exercise.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Scope(value = "session")
@Component(value = "demoController")
public class DemoController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public ResponseEntity getAllProducts(){
        return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
    }
}
