package ru.gb.lefandoc.javaeehw.utils;

import ru.gb.lefandoc.javaeehw.model.Product;

import java.util.List;
import java.util.Random;

public class ProductGen {

    private static final List<String> products = List.of(
            "apples", "bananas", "grapes", "oranges", "strawberries", "avocados",
            "butter", "cheese", "eggs", "milk", "yogurt",
            "pizza", "fish", "potatoes", "meat", "ice cream",
            "pet food", "kitty litter", "chew toys", "pet treats", "pet shampoo"
    );

    public static void fillProducts(List<Product> productsList, int amount) {

        for (int i = 1; i <= amount; i++) {
            productsList.add(
                    new Product(i, products.get(new Random().nextInt(products.size())), new Random().nextFloat())
            );
        }
    }

}
