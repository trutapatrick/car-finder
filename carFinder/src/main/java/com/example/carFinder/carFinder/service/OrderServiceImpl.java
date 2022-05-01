package com.example.carFinder.carFinder.service;

import com.example.carFinder.carFinder.model.Order;
import com.example.carFinder.carFinder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        Optional<Order> order = orderRepository.findOrderById(id);
        if (!order.isPresent()) {
            throw new IllegalArgumentException("Order not found!");
        }
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        Optional<Order> searchedOrderById = orderRepository.findOrderById(order.getId());
        if (!searchedOrderById.isPresent()) {
            throw new IllegalArgumentException("Order was not found !");
        }
        return orderRepository.save(order);
    }

    @Override
    public Order addOrder(Order order) {
        Optional<Order> searchedOrderById = orderRepository.findOrderById(order.getId());
        if (searchedOrderById.isPresent()) {
            throw new IllegalArgumentException("Order already exists !");
        }
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        Optional<Order> orderOptional = orderRepository.findOrderById(id);
        if (!orderOptional.isPresent()) {
            throw new IllegalArgumentException("Order doesn't exist !");
        }
        orderRepository.deleteById(id);
    }
}
