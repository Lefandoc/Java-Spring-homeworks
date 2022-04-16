package ru.gb.lefandoc.springmvchw.service.impl;//package ru.gb.lefandoc.springmvchw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springmvchw.model.Cart;
import ru.gb.lefandoc.springmvchw.model.Product;
import ru.gb.lefandoc.springmvchw.service.CartService;
import ru.gb.lefandoc.springmvchw.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final Cart cart;

    private final ProductService service;

    @Autowired
    public CartServiceImpl(Cart cart,
                           ProductService service) {
        this.cart = cart;
        this.service = service;
    }

    @Override
    public boolean putProduct(Integer id) {
        return cart.getCartStorage().add(service.getProduct(id));
    }

    @Override
    public List<Product> lookInCart() {
        return cart.getCartStorage();
    }

    @Override
    public boolean removeProduct(Integer id) {
        return cart.getCartStorage().remove(service.getProduct(id));
    }

}
