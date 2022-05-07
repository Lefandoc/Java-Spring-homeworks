package ru.gb.lefandoc.springboothw.service;

import ru.gb.lefandoc.springboothw.controllers.model.Product;

import java.util.List;

public interface CartService {

    List<Product> getProductList(Integer userId);

    void changeCount(Integer id, Integer delta);

    void delete(Integer id);
}
