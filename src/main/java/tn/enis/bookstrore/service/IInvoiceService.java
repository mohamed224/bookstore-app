package tn.enis.bookstrore.service;

import tn.enis.bookstrore.model.Invoice;
import tn.enis.bookstrore.model.Order;

import java.util.List;

public interface IInvoiceService {

    String createInvoice(Order order);
    Invoice getInvoiceById(Long id);
    List<Invoice> getAllInvoices();
}
