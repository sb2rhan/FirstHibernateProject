package org.sbt.main;

import org.hibernate.Session;
import org.sbt.entities.Book;

import java.util.Map;

public class ConnectionDB {

    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();
        Map<String, Object> properties = connectionDB.getProperties();
        System.out.println(properties.toString());

        BookController bookController = new BookController();
        bookController.saveNewBook(new Book(1, "War and Peace", 1869, "Leo Tolstoy", 1225, 5000));
        bookController.listBooks();
    }

    public Map<String, Object> getProperties() {
        Session session = SessionCreator.getSession();

        Map<String, Object> properties = session.getProperties();
        session.close();

        return properties;
    }
}
