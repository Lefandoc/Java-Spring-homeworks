package ru.gb.lefandoc.springboothw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lefandoc.springboothw.controllers.model.User;
import ru.gb.lefandoc.springboothw.repository.UserRepository;
import ru.gb.lefandoc.springboothw.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findUser(String login, String password) {
        return repository.findUser(login, password);
    }
    
}
