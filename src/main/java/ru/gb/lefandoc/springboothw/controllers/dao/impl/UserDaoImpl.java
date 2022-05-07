package ru.gb.lefandoc.springboothw.controllers.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.lefandoc.springboothw.controllers.dao.UserDao;
import ru.gb.lefandoc.springboothw.controllers.model.User;
import ru.gb.lefandoc.springboothw.utils.SessionFactoryUtils;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private final SessionFactoryUtils sessionFactoryUtils;

    public UserDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public User findUser(String login, String password) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getResultList();
            User user = users.get(0);
            System.out.println(user);
            session.getTransaction().commit();
            return user;
        }
    }
    
}
