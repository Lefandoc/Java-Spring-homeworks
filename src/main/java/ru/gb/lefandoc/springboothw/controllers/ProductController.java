package ru.gb.lefandoc.springboothw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.lefandoc.springboothw.data.Product;
import ru.gb.lefandoc.springboothw.model.ProductDto;
import ru.gb.lefandoc.springboothw.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1//products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Product> getAll(@RequestParam(defaultValue = "0") Integer min,
                                @RequestParam(defaultValue = "100") Integer max,
                                @RequestParam(required = false) String title) {
//        return service.findAll();
//        return service.findBetween(min, max);
        return service.findSpec(min, max, title);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Product get(@PathVariable Long id) {
        return service.find(id);
    }

    @Deprecated(since = ":D")
    @GetMapping("/get_less")
    public List<Product> lessThan(@RequestParam Integer price) {
        return service.findLessThan(price);
    }

    @Deprecated(since = ":D")

    @GetMapping("/get_greater")
    public List<Product> greaterThan(@RequestParam Integer price) {
        return service.findGreaterThan(price);
    }

    @Deprecated(since = "added spec to findAll")
    @GetMapping("/get_btw")
    public List<Product> priceBetween(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "100") Integer max) {
        return service.findBetween(min, max);
    }

    @PostMapping("")
    public void add(@RequestBody ProductDto productDto) {
        service.add(productDto);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }

}
