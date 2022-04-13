package ru.gb.lefandoc.springintrohw.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springintrohw.model.Product;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getProducts();

    Product getProduct(Integer id);
}
