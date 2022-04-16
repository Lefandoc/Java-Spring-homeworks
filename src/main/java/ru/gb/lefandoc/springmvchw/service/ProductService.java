package ru.gb.lefandoc.springmvchw.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springmvchw.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(Integer id);
}
