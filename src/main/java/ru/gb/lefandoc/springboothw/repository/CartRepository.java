package ru.gb.lefandoc.springboothw.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springboothw.controllers.dao.impl.CartDaoImpl;
import ru.gb.lefandoc.springboothw.controllers.dao.impl.ProductDaoImpl;
import ru.gb.lefandoc.springboothw.controllers.model.Product;
import ru.gb.lefandoc.springboothw.utils.SessionFactoryUtils;

import java.util.List;

@Component
public class CartRepository {

    @Autowired
    SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    CartDaoImpl cartDao;

    public List<Product> getProductList(Integer userId) {
        return cartDao.findAll(userId);
    }

    public void changeCount(Integer id, Integer delta) {
        cartDao.changeCount(id, delta);
    }

    public void delete(Integer id) {
        cartDao.deleteById(id);
    }

}
