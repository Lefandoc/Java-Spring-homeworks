package ru.gb.lefandoc.springboothw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springboothw.controllers.model.Product;
import ru.gb.lefandoc.springboothw.repository.ProductRepository;
import ru.gb.lefandoc.springboothw.service.ProductService;

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

    @Override
    public void changeCount(Integer id, Integer delta) {
        repository.changeCount(id, delta);
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteProduct(id);
    }

//    @Override
//    public void fillProducts() {
//        repository.fillProducts();
//    }

}
