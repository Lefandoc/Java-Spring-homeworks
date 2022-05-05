package ru.gb.lefandoc.springboothw.controllers.dao;

import ru.gb.lefandoc.springboothw.controllers.model.Product;

import java.util.List;

public interface ProductDao {

    Product findById(Integer id);

    List<Product> findAll();

    void saveOrUpdate(Product product);

    void deleteById(Integer id);
    
}
