package ru.gb.lefandoc.springboothw.validators;

import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springboothw.exceptions.ValidationException;
import ru.gb.lefandoc.springboothw.model.CreateProductDto;
import ru.gb.lefandoc.springboothw.model.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {

    public static void validate(ProductDto productDto) {
        List<String> errors = new ArrayList<>();

        if (productDto.getPrice() < 1) {
            errors.add("Price can not be less than 1");
        }
        if (productDto.getTitle() == null || productDto.getTitle().isEmpty()) {
            errors.add("Invalid product title");
        }

        if (!errors.isEmpty()) throw new ValidationException(errors);
    }

    public static void validate(CreateProductDto productDto) {
        List<String> errors = new ArrayList<>();

//        if (productDto.getPrice() < 1) {
//            errors.add("Price can not be less than 1");
//        }
//        if (productDto.getTitle() == null || productDto.getTitle().isEmpty()) {
//            errors.add("Invalid product title");
//        }

        if (!errors.isEmpty()) throw new ValidationException(errors);
    }

}
