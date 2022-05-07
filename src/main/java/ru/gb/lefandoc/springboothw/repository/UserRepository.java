package ru.gb.lefandoc.springboothw.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springboothw.controllers.dao.impl.UserDaoImpl;
import ru.gb.lefandoc.springboothw.controllers.model.User;
import ru.gb.lefandoc.springboothw.utils.SessionFactoryUtils;

@Component
public class UserRepository {

    @Autowired
    SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    UserDaoImpl userDao;

    public User findUser(String login, String password) {
        return userDao.findUser(login, password);
    }
}
