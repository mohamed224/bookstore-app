package tn.enis.bookstrore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.bookstrore.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
