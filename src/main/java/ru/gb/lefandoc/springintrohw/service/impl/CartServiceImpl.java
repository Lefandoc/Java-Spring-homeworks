//package ru.gb.lefandoc.springintrohw.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ru.gb.lefandoc.springintrohw.Cart;
//import ru.gb.lefandoc.springintrohw.model.Product;
//import ru.gb.lefandoc.springintrohw.service.CartService;
//import ru.gb.lefandoc.springintrohw.service.ProductService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CartServiceImpl implements CartService {
//
//    private final Cart<Product> cart;
//
//    private final ProductService service;
//
//    @Autowired
//    public CartServiceImpl(Cart<Product> cart,
//                           ProductService service) {
//        this.cart = cart;
//        this.service = service;
//    }
//
//    @Override
//    public boolean putProduct(Integer id) {
//        return cart.getCartStorage().add(service.getProduct(id));
//    }
//
//    @Override
//    public List<Product> lookInCart() {
//        return cart.getCartStorage();
//    }
//
//}
