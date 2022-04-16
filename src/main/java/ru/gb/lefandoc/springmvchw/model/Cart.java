package ru.gb.lefandoc.springmvchw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springmvchw.model.Product;
import ru.gb.lefandoc.springmvchw.service.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Data
//@AllArgsConstructor
@Component
public class Cart {

    private List<Product> cartStorage;

    @PostConstruct
    public void init() {
        this.cartStorage = new ArrayList<>();
    }

    public ArrayList<Product> getCartStorage() {
        return (ArrayList<Product>) cartStorage;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        for (Product product : cartStorage) {
//            builder.append(product.toString());
//        }
//        return builder.toString();
//    }

    public String fullSum() {
        float sum = 0f;
        for (Product product : cartStorage) {
            sum += product.getCost();
        }
        return String.format("%.2f", sum);
    }
}
