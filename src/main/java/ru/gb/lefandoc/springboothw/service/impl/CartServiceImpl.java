package ru.gb.lefandoc.springboothw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springboothw.data.Product;
import ru.gb.lefandoc.springboothw.exceptions.ProductNotFoundException;
import ru.gb.lefandoc.springboothw.model.Cart;
import ru.gb.lefandoc.springboothw.repository.ProductRepository;
import ru.gb.lefandoc.springboothw.service.CartService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private Cart cart;

    private final ProductRepository productRepository;

    public CartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
//        Product newProduct = productRepository.findById(product.getId())
//                .orElseThrow(() -> new ProductNotFoundException("Can not found product with id:" + product.getId()));
//        productRepository.save(product);
        cart.addProduct(product);
    }

    @Override
    public List<Product> getProductList() {
        return cart.getCartStorage();
    }

    @Override
    public void changeCount(Integer id, Integer delta) {
//        repository.changeCount(id, delta);
    }

    @Override
    public void delete(Integer id) {
        cart.remove(id);
    }

    @Override
    public Integer getFullSum(Long id) {
        return cart.fullSum(id);
    }

}
