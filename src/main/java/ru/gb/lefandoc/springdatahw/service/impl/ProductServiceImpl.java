package ru.gb.lefandoc.springdatahw.service.impl;

import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springdatahw.data.Product;
import ru.gb.lefandoc.springdatahw.repository.ProductRepository;
import ru.gb.lefandoc.springdatahw.service.ProductService;

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
    public void add(String title, Integer price) {
        repository.save(new Product(title, price));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
