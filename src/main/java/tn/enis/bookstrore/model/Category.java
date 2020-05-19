package tn.enis.bookstrore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category extends BaseIdEntity{
    private String name;
    private byte [] picByte;
    @OneToMany(mappedBy = "category")
    private Collection<Book> books;
}
