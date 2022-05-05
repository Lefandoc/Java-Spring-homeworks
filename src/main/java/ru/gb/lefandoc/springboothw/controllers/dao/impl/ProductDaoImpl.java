package ru.gb.lefandoc.springboothw.controllers.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springboothw.controllers.model.Product;
import ru.gb.lefandoc.springboothw.controllers.dao.ProductDao;
import ru.gb.lefandoc.springboothw.utils.SessionFactoryUtils;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {

    private final SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }


    @Override
    public Product findById(Integer id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            System.out.println(product + " incoming pr");
            session.saveOrUpdate(product);
            // update MY работает, но всегда нужно указывать id
//            Optional.ofNullable(session.get(Product.class, product.getId())).ifPresentOrElse(p -> {
//                p.setTitle(product.getTitle());
//                p.setPrice(product.getPrice());
//            }, () -> session.save(product)); // save
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.remove(product);
            session.getTransaction().commit();
        }
    }

}
