package ru.gb.lefandoc.springboothw.service;

import ru.gb.lefandoc.springboothw.data.Product;

import java.util.List;

public interface CartService {

    void addProduct(Product product);

    List<Product> getProductList();

    void changeCount(Integer id, Integer delta);

    void delete(Integer id);

    Integer getFullSum(Long id);

}
