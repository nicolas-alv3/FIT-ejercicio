package com.fit.exercise;

import com.fit.exercise.model.Product;
import com.fit.exercise.persistence.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository) {
		return (args) -> {
			productRepository.save(new Product("Pitusas de vainilla",50.50, "Mas ricas que las de limon,bastante mas"));
			productRepository.save(new Product("Hacha sin filo",500.50, "Le falta afilar"));
			productRepository.save(new Product("Tablet de 2'",5000.50, "Ideal para ver series con dos dedos"));
			productRepository.save(new Product("Botella de vidrio",100.50, "Para el agua"));
			productRepository.save(new Product("Alfajor tatín",5.50, "El mejor del conurbano"));
			productRepository.save(new Product("Mila con roquefort",500.50, "Poquito roquefort, esta caro"));
			productRepository.save(new Product("Pizza con salchicha",500.50, "Salchichas precocidas pero vueltas a cocinar"));
		};
	}
}
