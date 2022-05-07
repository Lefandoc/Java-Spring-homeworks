package ru.gb.lefandoc.springboothw.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springboothw.controllers.dao.impl.ProductDaoImpl;
import ru.gb.lefandoc.springboothw.controllers.model.Product;
import ru.gb.lefandoc.springboothw.utils.SessionFactoryUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    @Autowired
    SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    ProductDaoImpl productDao;

//    @PostConstruct
//    public void init() {
//        this.sessionFactoryUtils = new SessionFactoryUtils();
//        this.sessionFactoryUtils.init();
//        this.productDao = new ProductDaoImpl(sessionFactoryUtils);

//        this.productList = new ArrayList<>(Arrays.asList(
//                new Product(1L, "Milk", 1.05f),
//                new Product(2L, "Eggs", 2.15f),
//                new Product(3L, "Nuts", 4.09f),
//                new Product(4L, "Beer", 3.12f),
//                new Product(5L, "Fish", 2.78f),
//                new Product(6L, "Ice cream", 0.99f),
//                new Product(7L, "Curd cheese", 0.83f)
//        ));
//    }

    public List<Product> getProductList() {
        return productDao.findAll();
    }

    public Product getProduct(Integer id) {
        return productDao.findById(id);
//        return productList.stream().filter(p -> p.getId().equals(id)).findFirst()
//                .orElse(new Product(99L, "GOLDEN APPLE", 300f)); // easter egg
//                .orElseThrow(RuntimeException::new);
    }

    public void deleteProduct(Integer id) {
        productDao.deleteById(id);
//        Product product = getProduct(id);
//        productList.remove(product);
    }

    public void addCart(Integer id) {
        productDao.addCart(id);
    }
}
