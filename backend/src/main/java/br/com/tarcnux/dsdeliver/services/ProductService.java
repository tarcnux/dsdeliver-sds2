package br.com.tarcnux.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarcnux.dsdeliver.dto.ProductDTO;
import br.com.tarcnux.dsdeliver.entities.Product;
import br.com.tarcnux.dsdeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	//Dependence Injection
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findAllByOrderByNameAsc();
		//Product List conversion to ProductDTO with Lambda function & map
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
}
