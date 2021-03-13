package com.company.work_with_db;

import com.company.Book;

import java.util.ArrayList;

public interface IBookRepository {
    ArrayList<Book> searchBookByTitle(String title);
    Book getBookByISBN(int ISBN);
    boolean addBook(Book book);
    boolean removeBookByISBN(int ISBN);
}
