package ru.gb.lefandoc.springmvchw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springmvchw.model.Product;
import ru.gb.lefandoc.springmvchw.repository.ProductRepository;
import ru.gb.lefandoc.springmvchw.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getProducts() {
        return repository.getProductList();
    }

    @Override
    public Product getProduct(Integer id) {
        return repository.getProduct(id);
    }
}
