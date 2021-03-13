package com.company.work_with_db;

import java.util.Scanner;

public class MyApp {
    private final Control controller;
    private final Scanner scanner;
    Scanner sc = new Scanner(System.in);

    public MyApp(Control controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);

    }

    public void Start(){
        while(true){
            System.out.println("Choose one option:\n 1) Search for book by name\n 2) Get book by ISBN\n 3) Add book\n 4) Remove book\n 0) Exit\n");
            int choice = scanner.nextInt();
            if (choice==1) {
                searchBookByTitleMenu();

            }
            else if (choice==2) {
                getBookByISBNMenu();
            }
            else if (choice==3) {
                addBookMenu();
            }
            else if (choice==4) {
                removeBookByISBNMenu();
            }
            else {
                break;
            }

            System.out.println("*********************");
        }
    }

    public void searchBookByTitleMenu(){
        System.out.println("Write the name of Book:");
        String title = scanner.next();
        String result = controller.searchBookByTitle(title);
        System.out.println(result);
    }
    public void getBookByISBNMenu() {
        System.out.println("Write the ISBN of book!");
        int id = scanner.nextInt();
        String result = controller.getBookByISBN(id);
        System.out.println(result);
    }

    public void addBookMenu() {
        System.out.println("Write the ISBN of book!");
        int id = scanner.nextInt();
        System.out.println("Write the name of book!");
        String title = scanner.next();
        System.out.println("Excellent!");

        System.out.println("Write the name of Author!");
        String author = scanner.next();
        System.out.println("Great!");

        System.out.println("Write book's genre");
        String genre = scanner.next();
        System.out.println("Good job!");

        System.out.println("Write book's edition");
        String book_edition = scanner.next();


        String result = controller.addBook(id,title,author,genre,book_edition);

        System.out.println(result);
    }

    public void removeBookByISBNMenu() {
        System.out.println("Write book's ISBN!");
        int id = scanner.nextInt();

        String result = controller.removeBookByISBN(id);

        System.out.println(result);
    }

}
