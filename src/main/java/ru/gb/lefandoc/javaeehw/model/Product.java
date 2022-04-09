package ru.gb.lefandoc.javaeehw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private int id;
    private String title;
    private float cost;

    @Override
    public String toString() {
        return String.format("Product #%d title: '%s' cost: %.3f", id, title, cost);
    }

}
