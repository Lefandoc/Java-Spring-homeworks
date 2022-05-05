package ru.gb.lefandoc.springboothw.service;

import ru.gb.lefandoc.springboothw.controllers.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(Integer id);

    void changeCount(Integer id, Integer delta);

    void deleteProduct(Integer id);

//    void fillProducts();

}
