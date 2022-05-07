package ru.gb.lefandoc.springboothw.controllers.dao;

import ru.gb.lefandoc.springboothw.controllers.model.User;

public interface UserDao {

    User findUser(String login, String password);
    
}
