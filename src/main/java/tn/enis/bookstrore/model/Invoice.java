package tn.enis.bookstrore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Invoice extends BaseIdEntity {
    private Date date;
    @OneToOne
    private Order order;
    @OneToOne(mappedBy = "invoice")
    private Payment payment;
    private boolean isBillPaid;
    @Transient
    private double exclTaxesAmount;
    @Transient
    private double inclTaxesAmount;
}
