package br.com.tarcnux.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarcnux.dsdeliver.dto.OrderDTO;
import br.com.tarcnux.dsdeliver.dto.ProductDTO;
import br.com.tarcnux.dsdeliver.entities.Order;
import br.com.tarcnux.dsdeliver.entities.OrderStatus;
import br.com.tarcnux.dsdeliver.entities.Product;
import br.com.tarcnux.dsdeliver.repositories.OrderRepository;
import br.com.tarcnux.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	//Dependence Injection
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository; 
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		//Product List conversion to ProductDTO with Lambda function & map
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(),
				dto.getLongitude(),Instant.now(), OrderStatus.PENDING);
		
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = repository.save(order);
		return new OrderDTO(order);
	}
}
