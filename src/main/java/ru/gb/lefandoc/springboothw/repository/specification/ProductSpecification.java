package ru.gb.lefandoc.springboothw.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.lefandoc.springboothw.data.Product;

public class ProductSpecification {

    public static Specification<Product> priceLessThan(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> priceGreaterThan(Integer price) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price));
    }

    public static Specification<Product> priceBetween(Integer min, Integer max) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), min, max);
    }

    public static Specification<Product> partTitleEquals(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", title));
    }
}
