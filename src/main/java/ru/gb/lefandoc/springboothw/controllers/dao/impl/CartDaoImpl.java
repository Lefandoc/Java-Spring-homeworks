package ru.gb.lefandoc.springboothw.controllers.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springboothw.controllers.dao.CartDao;
import ru.gb.lefandoc.springboothw.controllers.model.User;
import ru.gb.lefandoc.springboothw.controllers.model.Product;
import ru.gb.lefandoc.springboothw.utils.SessionFactoryUtils;

import java.util.List;

@Component
public class CartDaoImpl implements CartDao {

    private final SessionFactoryUtils sessionFactoryUtils;

    public CartDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
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
    public List<Product> findAll(Integer userId) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.find(User.class, userId);
            List<Product> products = user.getProductList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.find(User.class, 1);
            user.getProductList().stream()
                    .filter(product -> product.getId().equals(id))
                    .findFirst()
                    .ifPresent(user.getProductList()::remove);
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void changeCount(Integer id, Integer delta) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setCount(product.getCount() + delta);
            session.getTransaction().commit();
        }
    }

}
