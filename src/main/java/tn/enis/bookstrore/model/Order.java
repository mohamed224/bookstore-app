package tn.enis.bookstrore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @OneToOne(mappedBy = "order",cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    private Invoice invoice;
}
