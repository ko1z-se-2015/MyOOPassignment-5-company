package kz.aitu.oop.practice.assignment5.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager implements IDBManager {
    @Override
    public Connection getConnection() { // connection to database
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Assignment5", "postgres", "daniar11");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
