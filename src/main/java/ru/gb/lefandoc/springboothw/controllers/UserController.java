package ru.gb.lefandoc.springboothw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.lefandoc.springboothw.controllers.model.User;
import ru.gb.lefandoc.springboothw.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public User login(@RequestParam String login, @RequestParam String password) {
        return service.findUser(login, password);
    }

}
