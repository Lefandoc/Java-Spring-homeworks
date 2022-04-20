package ru.gb.lefandoc.springboothw.repository;

import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springboothw.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void fillProducts() {
        this.productList = new ArrayList<>(Arrays.asList(
                new Product(1, "Milk", 1.05f, 3),
                new Product(2, "Eggs", 2.15f, 9),
                new Product(3, "Nuts", 4.09f, 5),
                new Product(4, "Beer", 3.12f, 2),
                new Product(5, "Fish", 2.78f, 1),
                new Product(6, "Ice cream", 0.99f, 2),
                new Product(7, "Curd cheese", 0.83f, 6)
        ));
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Product getProduct(Integer id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElse(new Product(99, "GOLDEN APPLE", 300f, 64)); // easter egg
//                .orElseThrow(RuntimeException::new);
    }

    public void changeCount(Integer id, Integer delta) {
        Product product = getProduct(id);
        int index = productList.indexOf(product);
        product.setCount(product.getCount() + delta);
        productList.set(index, product);
    }

    public void deleteProduct(Integer id) {
        Product product = getProduct(id);
        productList.remove(product);
    }

}
