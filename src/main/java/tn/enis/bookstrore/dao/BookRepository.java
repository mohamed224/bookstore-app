package tn.enis.bookstrore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.bookstrore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
