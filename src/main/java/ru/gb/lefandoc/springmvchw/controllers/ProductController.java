package ru.gb.lefandoc.springmvchw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.lefandoc.springmvchw.model.Product;
import ru.gb.lefandoc.springmvchw.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(final ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getProduct(Model model, @PathVariable Integer id){
        Product product = service.getProduct(id);
        model.addAttribute("product", product);
        return "product_page";
    }

    @GetMapping("/all")
    public String getProducts(Model model){
        model.addAttribute("products", service.getProducts());
        return "products_info_page";
    }

}
