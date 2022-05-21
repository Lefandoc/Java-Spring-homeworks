package ru.gb.lefandoc.springboothw.service;

import ru.gb.lefandoc.springboothw.data.Product;

import java.util.List;

public interface ProductService {

    Product find(Long id);

    List<Product> findAll();

    void add(Product product);

    void delete(Long id);

    List<Product> findLessThan(Integer price);

    List<Product> findGreaterThan(Integer price);

    List<Product> findBetween(Integer min, Integer max);
}
