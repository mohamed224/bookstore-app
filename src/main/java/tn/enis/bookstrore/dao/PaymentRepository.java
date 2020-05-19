package tn.enis.bookstrore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.bookstrore.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
