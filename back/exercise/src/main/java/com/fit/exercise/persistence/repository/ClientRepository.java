package com.fit.exercise.persistence.repository;

import com.fit.exercise.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
