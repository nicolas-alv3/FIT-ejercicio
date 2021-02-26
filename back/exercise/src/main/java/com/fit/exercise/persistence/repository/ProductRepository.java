package com.fit.exercise.persistence.repository;

import com.fit.exercise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
