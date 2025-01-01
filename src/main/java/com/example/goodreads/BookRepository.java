package com.example.goodreads;

import java.util.*;
import com.example.goodreads.Book;

public interface BookRepository {

    public ArrayList<Book> getBooks();

    public Book getBookById(int id);

    public Book addBook(Book book);

    public Book updateBook(int id, Book book);

    void deleteBook(int id);

}