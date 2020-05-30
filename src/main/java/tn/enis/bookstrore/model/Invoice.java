package tn.enis.bookstrore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tn.enis.bookstrore.util.converter.PaymentModeConverter;
import tn.enis.bookstrore.util.enumerations.PaymentMode;

import javax.persistence.*;
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
    @JsonIgnore
    private Payment payment;
    private boolean isBillPaid;
    @Transient
    private double exclTaxesAmount;
    @Transient
    private double inclTaxesAmount;
}
