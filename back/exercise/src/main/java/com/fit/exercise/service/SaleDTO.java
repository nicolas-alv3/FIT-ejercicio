package com.fit.exercise.service;

import com.fit.exercise.model.Product;

import java.time.LocalDate;
import java.util.List;

public class SaleDTO {
    public List<Product> products;
    public Long clientID;
    public LocalDate date;
}
