package com.example.goodreads;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;

@RestController
public class BookController {

    BookService bookSer = new BookService();

    @GetMapping("/books")
    public ArrayList<Book> getBooks() {
        return bookSer.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int id) {
        return bookSer.getBookById(id);
    }

}