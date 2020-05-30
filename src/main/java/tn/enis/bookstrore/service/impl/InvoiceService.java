package tn.enis.bookstrore.service.impl;

import org.springframework.stereotype.Service;
import tn.enis.bookstrore.dao.InvoiceRepository;
import tn.enis.bookstrore.model.Invoice;
import tn.enis.bookstrore.model.Order;
import tn.enis.bookstrore.service.IInvoiceService;
import tn.enis.bookstrore.util.constants.ConstantsValue;

import java.util.Date;
import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public String createInvoice(Order order) {
        Invoice invoice = new Invoice();
        invoice.setDate(new Date());
        invoice.setBillPaid(false);
        invoice.setOrder(order);
        invoiceRepository.save(invoice);
        return "Votre facture a été créé avec succès.";
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id).get();
        double exclTaxesAmount = invoice.getOrder().getTotalAmount();
        double inclTaxesAmount = exclTaxesAmount + exclTaxesAmount* ConstantsValue.RATE;
        invoice.setExclTaxesAmount(exclTaxesAmount);
        invoice.setInclTaxesAmount(inclTaxesAmount);
        return invoice;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return null;
    }
}
