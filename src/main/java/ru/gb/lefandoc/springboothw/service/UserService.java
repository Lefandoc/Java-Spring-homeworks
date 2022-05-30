package ru.gb.lefandoc.springboothw.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.gb.lefandoc.springboothw.data.Role;
import ru.gb.lefandoc.springboothw.data.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    public Optional<User> findByUsername(String username);

}
