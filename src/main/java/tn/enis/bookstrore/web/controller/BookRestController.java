package tn.enis.bookstrore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enis.bookstrore.model.Book;
import tn.enis.bookstrore.service.IBookService;

import java.util.List;

@RestController
public class BookRestController {

    private IBookService bookService;

    @Autowired
    public BookRestController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id).get();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        return bookService.updateBook(book,id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
}
