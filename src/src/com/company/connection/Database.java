package com.company.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements IDatabase{
    private static String url="jdbc:postgresql://localhost:5432/example_8";
    public static Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url,"postgres","20022310");

            return connection;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    private static Database database;
//    private Connection connection;
//
//    private final String DATABASE_DRIVER = "org.mariadb.jdbc.Driver";
//    private final String DATABASE_URL = "jdbc:mariadb://localhost:3306/";
//    private final String DATABASE_SCHEMA = "";
//    private final String DATABASE_USERNAME = "postgres";
//    private final String DATABASE_PASSWORD = "";
//
//    private Database() {
//        try {
//            Class.forName(DATABASE_DRIVER);
//            String url = DATABASE_URL + DATABASE_SCHEMA;
//            connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Database getInstance() throws SQLException {
//        if (database == null || database.getConnection().isClosed()) {
//            database = new Database();
//        }
//        return database;
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
}
