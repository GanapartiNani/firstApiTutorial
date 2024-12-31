package com.example.goodreads;

import java.util.*;
import com.example.goodreads.BookRepository;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookService implements BookRepository {

    private HashMap<Integer, Book> hmap = new HashMap<>();

    public BookService() {
        Book b1 = new Book(1, "psychology of money", "book1.jpg");
        Book b2 = new Book(2, "300 strecthes", "book2.jpg");
        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);
    }

    @Override
    public ArrayList<Book> getBooks() {
        Collection<Book> bookCollection = hmap.values();
        ArrayList<Book> bookList = new ArrayList<>(bookCollection);
        return bookList;
    }

    public Book getBookById(int id) {
        Book book = hmap.get(id);
        if (book == null) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
           return book;
        }
    }
}