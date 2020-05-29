package tn.enis.bookstrore.service;

import tn.enis.bookstrore.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book saveBook(Book book);
    Optional<Book> getBookById(Long id);
    List<Book> getAllBooks();
    Book updateBook(Book book,Long id);
    void deleteBookById(Long id);
}
