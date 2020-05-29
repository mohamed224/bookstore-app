package tn.enis.bookstrore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.bookstrore.dao.BookRepository;
import tn.enis.bookstrore.model.Book;
import tn.enis.bookstrore.service.IBookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book, Long id) {
        book.setId(id);
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
