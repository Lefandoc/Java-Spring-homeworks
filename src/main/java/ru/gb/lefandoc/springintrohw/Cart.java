package ru.gb.lefandoc.springintrohw;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springintrohw.model.Product;
import ru.gb.lefandoc.springintrohw.service.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> cartStorage;

    @Autowired
    private ProductService service;

    @PostConstruct
    public void init() {
        this.cartStorage = new ArrayList<>();
    }

    public boolean putProduct(Integer id) {
        Product product = service.getProduct(id);
        return cartStorage.add(product);
    }


    public List<Product> lookInCart() {
        return cartStorage;
    }


    public boolean removeProduct(Integer id) {
        Product product = service.getProduct(id);
        return cartStorage.remove(product);
    }
}
