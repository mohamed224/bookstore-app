package tn.enis.bookstrore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.bookstrore.dao.ClientRepository;
import tn.enis.bookstrore.dao.OrderItemRepository;
import tn.enis.bookstrore.dao.OrderRepository;
import tn.enis.bookstrore.model.Client;
import tn.enis.bookstrore.model.Order;
import tn.enis.bookstrore.model.OrderItem;
import tn.enis.bookstrore.service.IOrderService;
import tn.enis.bookstrore.util.enumerations.DeliveryMethod;

import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void placeOrder(List<OrderItem> items, String email, String deliveryMethod) {
        double totalAmount = items.stream().mapToDouble(item -> (item.getQuantity() * item.getPrice())).sum();
        Order order = new Order();
        Client client = clientRepository.findByEmail(email);
        if(client==null){
            throw new RuntimeException("Ce client n'existe pas");
        }
        DeliveryMethod method = DeliveryMethod.fromShortName(deliveryMethod);
        order.setClient(client);
        order.setDate(new Date());
        order.setDeliveryMethod(method);
        order.setTotalAmount(totalAmount);
        Order orderSaved = orderRepository.save(order);
        if (order != null) {
            for (OrderItem item : items) {
                item.setOrder(orderSaved);
            }
            orderItemRepository.saveAll(items);
        }
    }
}
