package ru.gb.lefandoc.springboothw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.lefandoc.springboothw.controllers.model.Product;
import ru.gb.lefandoc.springboothw.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping("/items")
//    public List<Product> cartItems(@RequestParam Integer userId) {
    public List<Product> cartItems() {
        Integer userId = 1;
        return service.getProductList(userId);
    }

    @GetMapping("/change_count")
    public void changeCount(@RequestParam Integer productId, @RequestParam Integer delta){
        service.changeCount(productId, delta);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Integer productId) {
        service.delete(productId);
    }
}
