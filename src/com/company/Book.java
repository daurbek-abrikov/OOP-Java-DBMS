package com.company;

public class Book {
    private int ISBN;
    private String title;
    private String author;
    private String genre;
    private String book_edition;

    public Book() {
    }

    public Book(String title, String author, String genre, String book_edition) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.book_edition = book_edition;
    }

    public Book(int ISBN, String title, String author, String genre, String book_edition) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.book_edition = book_edition;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBook_edition() {
        return book_edition;
    }

    public void setBook_edition(String book_edition) {
        this.book_edition = book_edition;
    }

    @Override
    public String toString() {
        return "Book " +
                "ISBN:" + ISBN +
                ", Title:" + title +
                ", Author:" + author +
                ", Genre:" + genre +
                ", Book edition:" + book_edition + "\n"
                ;
    }
}
