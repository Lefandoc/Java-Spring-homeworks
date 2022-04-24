package ru.gb.lefandoc.hibernatehw;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    void saveOrUpdate(Product product);

    void deleteById(Long id);
    
}
