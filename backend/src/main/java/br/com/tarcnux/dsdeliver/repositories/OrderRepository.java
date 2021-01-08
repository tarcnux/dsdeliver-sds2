package br.com.tarcnux.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tarcnux.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
