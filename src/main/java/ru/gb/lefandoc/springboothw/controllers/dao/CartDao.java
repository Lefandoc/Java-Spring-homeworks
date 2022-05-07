package ru.gb.lefandoc.springboothw.controllers.dao;

import ru.gb.lefandoc.springboothw.controllers.model.Product;

import java.util.List;

public interface CartDao {

    Product findById(Integer id);

    List<Product> findAll(Integer id);

    void deleteById(Integer id);

    void changeCount(Integer id, Integer delta);
}
