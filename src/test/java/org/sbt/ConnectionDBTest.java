package org.sbt;

import org.junit.Test;
import org.sbt.entities.Book;
import org.sbt.main.BookController;
import org.sbt.main.ConnectionDB;

import java.util.Map;

public class ConnectionDBTest {
    /*
     *Hibernate configuration на вашем компьютере.
     *Постарайтесь так же “замапить” класс, создать конфигурационный файл,
     *конфигурацию и поиграться с properties hibernate.
    */

    @Test
    public void testCode() {
        ConnectionDB connectionDB = new ConnectionDB();
        Map<String, Object> properties = connectionDB.getProperties();
        System.out.println(properties.toString());

        BookController bookController = new BookController();
        bookController.saveNewBook(new Book(1, "War and Peace", 1869, "Leo Tolstoy", 1225, 5000));

        System.out.println("Added books:");
        bookController.listBooks();
    }
}
