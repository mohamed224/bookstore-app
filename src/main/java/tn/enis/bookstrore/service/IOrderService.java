package tn.enis.bookstrore.service;

import tn.enis.bookstrore.model.Order;
import tn.enis.bookstrore.model.OrderItem;

import java.util.List;

public interface IOrderService {

    List<Order> getAllOrders();

    void placeOrder(List<OrderItem> items, String email, String deliveryMethod);
}
