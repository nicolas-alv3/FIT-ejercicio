package com.fit.exercise.persistence.repository;

import com.fit.exercise.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<ShoppingCart,Long> {
}
