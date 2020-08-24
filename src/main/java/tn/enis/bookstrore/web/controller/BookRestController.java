package tn.enis.bookstrore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.enis.bookstrore.model.Book;
import tn.enis.bookstrore.service.IBookService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class BookRestController {

    private IBookService bookService;

    private byte [] bytes;

    @Autowired
    public BookRestController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("imageFile")MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        book.setPicByte(this.bytes);
        this.bytes = null;
        return bookService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).get();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        book.setPicByte(this.bytes);
        this.bytes = null;
        return bookService.updateBook(book, id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
