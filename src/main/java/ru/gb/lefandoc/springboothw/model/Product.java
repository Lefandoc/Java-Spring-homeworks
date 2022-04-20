package ru.gb.lefandoc.springboothw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Integer id;

    private String title;

    private float cost;

    private Integer count;

    @Override
    public String toString() {
        return "Product " +
                "#" + id +
                ", title: " + title +
                ", cost: " + cost +
                ", count: " + count;
    }

}
