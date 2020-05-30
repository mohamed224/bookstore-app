package tn.enis.bookstrore.web.controller;

import org.springframework.web.bind.annotation.*;
import tn.enis.bookstrore.model.Invoice;
import tn.enis.bookstrore.model.Order;
import tn.enis.bookstrore.service.IInvoiceService;

@RestController
public class InvoiceRestController {

    private IInvoiceService invoiceService;

    public InvoiceRestController(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/invoices")
    public String createInvoice(@RequestBody Order order){
        return invoiceService.createInvoice(order);
    }

    @GetMapping("/invoices/{id}")
    public Invoice getInvoiceById(@PathVariable Long id){
        return invoiceService.getInvoiceById(id);
    }
}
