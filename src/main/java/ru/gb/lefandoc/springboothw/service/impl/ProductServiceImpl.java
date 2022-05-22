package ru.gb.lefandoc.springboothw.service.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springboothw.model.ProductDto;
import ru.gb.lefandoc.springboothw.repository.specification.ProductSpecification;
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
    public List<Product> findSpec(Integer minPrice, Integer maxPrice, String title) {
        Specification<Product> spec = Specification.where(null);

        if (minPrice != 0) {
            spec = spec.and(ProductSpecification.priceGreaterThan(minPrice));
        }
        if (maxPrice != 100) {
            spec = spec.and(ProductSpecification.priceLessThan(maxPrice));
        }
        if (title != null && !title.isEmpty()) {
            spec = spec.and(ProductSpecification.partTitleEquals(title));
        }

        return repository.findAll(spec);
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
    public void add(ProductDto productDto) {
        repository.save(new Product(productDto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
