package com.example.carFinder.carFinder.controller;

import com.example.carFinder.carFinder.model.Order;
import com.example.carFinder.carFinder.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/orders")
@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> ordersList = orderServiceImpl.getAllOrders();
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable Integer id) {
        try {
            Optional<Order> order = orderServiceImpl.getOrderById(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrder = orderServiceImpl.addOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable(value = "id") Integer id) {
       Optional <Order> updateOrder = orderServiceImpl.getOrderById(id);
       updateOrder.get().setNumberTracking(order.getNumberTracking());
       updateOrder.get().setAddress(order.getAddress());
       updateOrder.get().setOrderType(order.getOrderType());
       updateOrder.get().setOrderDate(order.getOrderDate());
       orderServiceImpl.updateOrder(updateOrder.get());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }


    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Integer id) {
        try {
            orderServiceImpl.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
