package ru.gb.lefandoc.springboothw.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {

    public ValidationException(List<String> message) {
        super(String.valueOf(message));
    }

}
