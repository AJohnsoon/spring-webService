package com.webservice.application.services;

import com.webservice.application.entities.Order;
import com.webservice.application.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){ return orderRepository.findAll(); }

    public Order findById(Long id){
        Optional<Order> orderObject = orderRepository.findById(id);
        return orderObject.get();
    }
}
