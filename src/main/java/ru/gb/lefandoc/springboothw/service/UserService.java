package ru.gb.lefandoc.springboothw.service;

import ru.gb.lefandoc.springboothw.controllers.model.User;

public interface UserService {

    User findUser(String login, String password);
    
}
