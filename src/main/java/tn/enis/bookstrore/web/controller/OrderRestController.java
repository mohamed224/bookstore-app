package tn.enis.bookstrore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enis.bookstrore.model.Order;
import tn.enis.bookstrore.model.OrderItem;
import tn.enis.bookstrore.service.IOrderService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderRestController {

    private IOrderService orderService;

    @Autowired
    public OrderRestController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public Order placeOrder(@RequestBody List<OrderItem> items, @RequestParam("email") String email,
                                            @RequestParam("deliveryMethod") String deliveryMethod) {
        Order order = orderService.placeOrder(items, email, deliveryMethod);
        return order;

    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
