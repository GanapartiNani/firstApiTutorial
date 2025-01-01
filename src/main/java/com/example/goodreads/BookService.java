package com.example.goodreads;

import java.util.*;
import com.example.goodreads.BookRepository;
import com.example.goodreads.Book;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookService implements BookRepository {

    private HashMap<Integer, Book> hmap = new HashMap<>();
    int unqBookId = 3;

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
        } else {
            return book;
        }
    }

    public Book addBook(Book book) {
        book.setId(unqBookId);
        hmap.put(unqBookId, book);
        unqBookId = unqBookId + 1;
        return book;

    }

    public Book updateBook(int id, Book book) {
        Book existingBook = hmap.get(id);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (book.getName() != null) {
            existingBook.setName(book.getName());
        }

        if (book.getImageUrl() != null) {
            existingBook.setImageUrl(book.getImageUrl());
        }
        return existingBook;
    }

    public void deleteBook(int id){
        Book existingBook = hmap.get(id);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            hmap.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}