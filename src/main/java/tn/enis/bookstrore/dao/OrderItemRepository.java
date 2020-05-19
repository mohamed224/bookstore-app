package tn.enis.bookstrore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.bookstrore.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
