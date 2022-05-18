package ru.gb.lefandoc.springdatahw.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.lefandoc.springdatahw.data.Product;
import ru.gb.lefandoc.springdatahw.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    public @ResponseBody Product get(@PathVariable Long id) {
        return service.find(id);
    }

    @GetMapping("/get")
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/get_less")
    public List<Product> lessThan(@RequestParam Integer price) {
        return service.findLessThan(price);
    }

    @GetMapping("/get_greater")
    public List<Product> greaterThan(@RequestParam Integer price) {
        return service.findGreaterThan(price);
    }

    @GetMapping("/get_btw")
    public List<Product> moreThan(@RequestParam Integer min, @RequestParam Integer max) {
        return service.findBetween(min, max);
    }

    @PostMapping("/add")
    public void add(@RequestParam String title, @RequestParam Integer price) {
        service.add(title, price);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
