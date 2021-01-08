package br.com.tarcnux.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarcnux.dsdeliver.dto.OrderDTO;
import br.com.tarcnux.dsdeliver.entities.Order;
import br.com.tarcnux.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	//Dependence Injection
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		//Product List conversion to ProductDTO with Lambda function & map
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
}
