package ru.gb.lefandoc.springmvchw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Integer id;

    private String title;

    private float cost;

    @Override
    public String toString() {
        return "Product " +
                "#" + id +
                ", title: " + title +
                ", cost: " + cost;
    }

    public String printTC() {
        return "Title: " + title +
                ", cost: " + cost;
    }

}
