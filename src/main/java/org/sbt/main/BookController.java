package org.sbt.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.sbt.entities.Book;

import java.util.Iterator;
import java.util.List;

public class BookController {

    public void updateTitle(String title, Integer id) {
        Session session = SessionCreator.getSession();

        session.getTransaction().begin();
        Book book = session.find(Book.class, id);
        book.setTitle(title);
        session.getTransaction().commit();

        session.close();
    }

    public void listBooks(){
        Session session = SessionCreator.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            List books = session.createQuery("FROM Book").getResultList();
            for (Iterator iterator = books.iterator(); iterator.hasNext();){
                Book book = (Book) iterator.next();
                System.out.print("Title: " + book.getTitle());
                System.out.print("  Year: " + book.getYear());
                System.out.print("  Author: " + book.getAuthor());
                System.out.print("  Pages: " + book.getPages());
                System.out.print("  Price: " + book.getPrice());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateExistingBook(Integer id, String title, int year, String author, int pages, double price) {
        Session session = SessionCreator.getSession();

        session.getTransaction().begin();
        Book book = session.find(Book.class, id);
        book.setTitle(title);
        book.setYear(year);
        book.setAuthor(author);
        book.setPages(pages);
        book.setPrice(price);
        session.getTransaction().commit();

        session.close();
    }

    public void saveNewBook(Book book) {
        Session session = SessionCreator.getSession();

        session.getTransaction().begin();
        session.persist(book);
        session.getTransaction().commit();

        session.close();
    }
}
