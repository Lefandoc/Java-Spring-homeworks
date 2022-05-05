package ru.gb.lefandoc.springboothw.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springboothw.controllers.model.Product;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryUtils {

    private SessionFactory factory;

    @PostConstruct
    public void init() {
        factory = new Configuration()
                .addAnnotatedClass(Product.class)
//                .configure("hibernate.properties")
                .buildSessionFactory();
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }

}
