package tn.enis.bookstrore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tn.enis.bookstrore.util.converter.PaymentModeConverter;
import tn.enis.bookstrore.util.enumerations.PaymentMode;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment extends BaseIdEntity {
    private Date paymentDate;
    @OneToOne
    private Invoice invoice;
    @Convert(converter = PaymentModeConverter.class)
    private PaymentMode paymentMode;

}
