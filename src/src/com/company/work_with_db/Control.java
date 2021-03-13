package com.company.work_with_db;

import com.company.Book;

public class Control {
    private final IBookRepository bookRepository;

    public Control(IBookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public String searchBookByTitle(String title){
        String result = bookRepository.searchBookByTitle(title).toString();

        return result;
    }

    public String getBookByISBN(int ISBN){
        String result = bookRepository.getBookByISBN(ISBN).toString();

        return result;
    }

    public String addBook(int ISBN, String title, String author, String genre, String book_edition){
        boolean added = bookRepository.addBook(new Book(ISBN,title,author,genre,book_edition));

        if(added){
            return "Book was added to Library. ";
        }
        return "Book was not added to Library. ";
    }

    public String removeBookByISBN(int ISBN){
        boolean removed = bookRepository.removeBookByISBN(ISBN);

        if(removed){
            return "Book was removed from Library. ";
        }
        return "Book was not removed from Library. ";
    }
}
