package tn.enis.bookstrore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book extends BaseIdEntity {
    private String name;
    private String description;
    private String author;
    private double price;
    private int quantity;
    private boolean available;
    private byte [] picByte;
    @ManyToOne
    private Category category;
}
