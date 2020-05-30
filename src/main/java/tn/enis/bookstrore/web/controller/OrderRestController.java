package tn.enis.bookstrore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enis.bookstrore.model.Order;
import tn.enis.bookstrore.model.OrderItem;
import tn.enis.bookstrore.service.IOrderService;

import java.util.List;

@RestController
public class OrderRestController {

    private IOrderService orderService;

    @Autowired
    public OrderRestController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody List<OrderItem> items , @RequestParam("email") String email,
                             @RequestParam("deliveryMethod") String deliveryMethod){
        orderService.placeOrder(items,email,deliveryMethod);
        return "Votre commande a été bien enrigistrée.";

    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
