package ru.gb.lefandoc.springmvchw.service;//package ru.gb.lefandoc.springmvchw.service;

import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springmvchw.model.Product;

import java.util.List;

public interface CartService {

    boolean putProduct(Integer id);

    List<Product> lookInCart();

    boolean removeProduct(Integer id);
}
