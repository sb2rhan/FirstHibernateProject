package org.sbt.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.sbt.entities.Book;

public class SessionCreator {
    private static final String RESOURCE_HIBERNATE_FILE = "hibernate.cfg.xml";

    private static final SessionFactory SESSION_FACTORY = new Configuration()
            .configure(RESOURCE_HIBERNATE_FILE)
            .addAnnotatedClass(Book.class)
            .buildSessionFactory();

    public static Session getSession() {
        return SESSION_FACTORY.openSession();
    }
}
