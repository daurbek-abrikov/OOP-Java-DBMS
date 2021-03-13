package com.company;

import com.company.connection.Database;
import com.company.connection.IDatabase;
import com.company.work_with_db.BookRepository;
import com.company.work_with_db.Control;
import com.company.work_with_db.IBookRepository;
import com.company.work_with_db.MyApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IDatabase dbManager = new Database();
        IBookRepository bookRepository = new BookRepository((Database) dbManager);
        Control controller = new Control(bookRepository);
        MyApp myApp = new MyApp(controller);
        Scanner scanner = new Scanner(System.in);
        myApp.Start();



    }
}
