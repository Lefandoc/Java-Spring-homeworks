package ru.gb.lefandoc.springboothw.service.impl;

import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springboothw.service.ProductService;
import ru.gb.lefandoc.springboothw.data.Product;
import ru.gb.lefandoc.springboothw.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product find(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Product> findLessThan(Integer price) {
        return repository.findAllByPriceLessThan(price);
    }

    @Override
    public List<Product> findGreaterThan(Integer price) {
        return repository.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findBetween(Integer min, Integer max) {
        return repository.findAllByPriceBetween(min, max);
    }

    @Override
    public void add(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
