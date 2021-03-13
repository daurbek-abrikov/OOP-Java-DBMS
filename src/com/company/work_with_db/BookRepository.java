package com.company.work_with_db;

import com.company.Book;
import com.company.connection.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookRepository implements IBookRepository {
    private final Database database;

    public BookRepository(Database database ){
        this.database=database;
    }

    @Override
    public ArrayList<Book> searchBookByTitle(String title) {
        Connection connection = null;
        try{
            connection = Database.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE title LIKE '%"+title+"%'");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Book> books = new ArrayList<>();

            while(resultSet.next()){
                Book book = new Book(resultSet.getInt("ISBN"), resultSet.getString("title"),
                        resultSet.getString("author"), resultSet.getString("genre"),
                        resultSet.getString("book_edition")  );
                books.add(book);

//                int is_bn = resultSet.getInt("ISBN");
//               String req_tit = resultSet.getString("title");
//                String req_aut = resultSet.getString("author");
//                String req_gen = resultSet.getString("genre");
//                String req_book = resultSet.getString("book_edition");
//
//                System.out.println("ISBN: "+is_bn);
//                System.out.println("Title: "+req_tit);
//                System.out.println("Author: "+req_aut);
//                System.out.println("Genre: "+req_gen);
//                System.out.println("Book edition: "+req_book);
//                System.out.println("*************************-----BOOKS-----***************************");
            }
            return books;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookByISBN(int ISBN) {
        Connection connection = null;
        try{
            connection = Database.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE ISBN=?");

            preparedStatement.setInt(1,ISBN);

            ResultSet resultSet = preparedStatement.executeQuery();

            Book book =new Book();

            if(resultSet.next()){
                book.setISBN(resultSet.getInt("ISBN"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGenre(resultSet.getString("genre"));
                book.setBook_edition(resultSet.getString("book_edition"));
            }
            return book;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        Connection connection = null;
        try{
            connection = Database.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books(ISBN,title,author,genre,book_edition) VALUES(?,?,?,?,?)");

            preparedStatement.setInt(1,book.getISBN());
            preparedStatement.setString(2,book.getTitle());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setString(4,book.getGenre());
            preparedStatement.setString(5,book.getBook_edition());

            preparedStatement.execute();

            return true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeBookByISBN(int ISBN) {
        Connection connection = null;
        try{
            connection = Database.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books WHERE ISBN=?");


            preparedStatement.setInt(1,ISBN);

            preparedStatement.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public static ArrayList<Book> printAll() {
        Connection connection = null;
        try{
            connection = Database.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Book> books = new ArrayList<>();

            while(resultSet.next()){
                Book book = new Book(resultSet.getInt("ISBN"), resultSet.getString("title"),
                        resultSet.getString("author"), resultSet.getString("genre"),
                        resultSet.getString("book_edition")  );
                books.add(book);

//                int is_bn = resultSet.getInt("ISBN");
//               String req_tit = resultSet.getString("title");
//                String req_aut = resultSet.getString("author");
//                String req_gen = resultSet.getString("genre");
//                String req_book = resultSet.getString("book_edition");
//
//                System.out.println("ISBN: "+is_bn);
//                System.out.println("Title: "+req_tit);
//                System.out.println("Author: "+req_aut);
//                System.out.println("Genre: "+req_gen);
//                System.out.println("Book edition: "+req_book);
//                System.out.println("*************************-----BOOKS-----***************************");
            }
            return books;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
