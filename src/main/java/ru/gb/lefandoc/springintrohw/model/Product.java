package ru.gb.lefandoc.springintrohw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

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

}
