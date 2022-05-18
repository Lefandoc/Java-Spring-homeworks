package ru.gb.lefandoc.springdatahw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.lefandoc.springdatahw.data.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceLessThan(Integer price);

    List<Product> findAllByPriceGreaterThan(Integer price);

    List<Product> findAllByPriceBetween(Integer min, Integer max);
}
