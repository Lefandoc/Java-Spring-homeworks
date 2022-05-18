package ru.gb.lefandoc.springdatahw.service;

import ru.gb.lefandoc.springdatahw.data.Product;

import java.util.List;

public interface ProductService {

    Product find(Long id);

    List<Product> findAll();

    void add(String title, Integer price);

    void delete(Long id);

    List<Product> findLessThan(Integer price);

    List<Product> findGreaterThan(Integer price);

    List<Product> findBetween(Integer min, Integer max);
}
