package tn.enis.bookstrore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.bookstrore.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
