package ru.gb.lefandoc.springboothw.service;

import ru.gb.lefandoc.springboothw.data.Product;
import ru.gb.lefandoc.springboothw.model.ProductDto;

import java.util.List;

public interface ProductService {

    Product find(Long id);

    List<Product> findAll();

    List<Product> findSpec(Integer minPrice, Integer maxPrice, String title);

    void add(Product product);

    void delete(Long id);

    List<Product> findLessThan(Integer price);

    List<Product> findGreaterThan(Integer price);

    List<Product> findBetween(Integer min, Integer max);

    void update(ProductDto productDto);
}
