package ru.gb.lefandoc.springintrohw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springintrohw.model.Product;
import ru.gb.lefandoc.springintrohw.repository.ProductRepository;
import ru.gb.lefandoc.springintrohw.service.ProductService;

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
