package ru.gb.lefandoc.springboothw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lefandoc.springboothw.data.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceLessThan(Integer price);

    List<Product> findAllByPriceGreaterThan(Integer price);

    List<Product> findAllByPriceBetween(Integer min, Integer max);

}
