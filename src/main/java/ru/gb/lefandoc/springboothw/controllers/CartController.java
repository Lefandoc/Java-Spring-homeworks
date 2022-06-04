package ru.gb.lefandoc.springboothw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.lefandoc.springboothw.data.Product;
import ru.gb.lefandoc.springboothw.model.CreateProductDto;
import ru.gb.lefandoc.springboothw.model.ProductDto;
import ru.gb.lefandoc.springboothw.service.CartService;
import ru.gb.lefandoc.springboothw.service.ProductService;
import ru.gb.lefandoc.springboothw.validators.ProductValidator;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    private final ProductService productService;

    private final ModelMapper mapper;

    @Autowired
    public CartController(CartService cartService, ProductService productService, ModelMapper mapper) {
        this.cartService = cartService;
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping("/items")
    public List<Product> cartItems() {
        return cartService.getProductList();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProductDto productDto) {
//        ProductValidator.validate(productDto);
//        Product product = mapper.map(productDto, Product.class);
        cartService.addProduct(productService.find(productDto.getId()));
    }

    @GetMapping("/sum")
    public Integer sum(@RequestBody CreateProductDto productDto) {
        return cartService.getFullSum(productDto.getId());
    }

    @GetMapping("/change_count")
    public void changeCount(@RequestParam Integer productId, @RequestParam Integer delta){
        cartService.changeCount(productId, delta);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Integer productId) {
        cartService.delete(productId);
    }
}
