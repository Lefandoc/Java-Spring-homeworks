package ru.gb.lefandoc.springboothw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.lefandoc.springboothw.controllers.model.Product;
import ru.gb.lefandoc.springboothw.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(final ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){
        return service.getProduct(id);
    }

    @GetMapping("/all")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/add_cart")
    public void addCart(@RequestParam Integer productId){
        service.addCart(productId);
    }

    @GetMapping("/delete")
    public void deleteProduct(@RequestParam Integer productId) {
        service.deleteProduct(productId);
    }

}
