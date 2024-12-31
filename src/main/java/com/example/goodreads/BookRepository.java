package com.example.goodreads;

import java.util.*;

public interface BookRepository {

    public ArrayList<Book> getBooks();

    public Book getBookById(int id);

}