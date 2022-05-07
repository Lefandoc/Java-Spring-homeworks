package ru.gb.lefandoc.springboothw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springboothw.controllers.model.Product;
import ru.gb.lefandoc.springboothw.repository.CartRepository;
import ru.gb.lefandoc.springboothw.service.CartService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    CartRepository repository;

    @Autowired
    public CartServiceImpl(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getProductList(Integer userId) {
        return repository.getProductList(userId);
    }

    @Override
    public void changeCount(Integer id, Integer delta) {
        repository.changeCount(id, delta);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

}
