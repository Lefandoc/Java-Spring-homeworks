package ru.gb.lefandoc.springmvchw.repository;

import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springmvchw.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        this.productList = new ArrayList<>(Arrays.asList(
                new Product(1, "Milk", 1.05f),
                new Product(2, "Eggs", 2.15f),
                new Product(3, "Nuts", 4.09f),
                new Product(4, "Beer", 3.12f),
                new Product(5, "Fish", 2.78f),
                new Product(6, "Ice cream", 0.99f),
                new Product(7, "Curd cheese", 0.83f)
        ));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct(Integer id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElse(new Product(99, "GOLDEN APPLE", 300f)); // easter egg
        //.orElseThrow(RuntimeException::new);
    }
}
