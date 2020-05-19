package tn.enis.bookstrore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tn.enis.bookstrore.util.converter.DeliveryMethodConverter;
import tn.enis.bookstrore.util.enumerations.DeliveryMethod;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order extends BaseIdEntity {
    private Date date;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Collection<OrderItem> orderItems;
    @ManyToOne
    private Client client;
    private double totalAmount;
    @Convert(converter = DeliveryMethodConverter.class)
    private DeliveryMethod deliveryMethod;
    @OneToOne(mappedBy = "order",cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    private Invoice invoice;
}
