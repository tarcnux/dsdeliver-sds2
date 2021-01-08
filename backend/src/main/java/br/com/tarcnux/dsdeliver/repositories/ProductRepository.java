package br.com.tarcnux.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tarcnux.dsdeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//Spring Data JPA Documentation
	//Query Methods - Query Creation
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	
	List<Product> findAllByOrderByNameAsc();
}
