package ru.gb.lefandoc.springboothw.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.lefandoc.springboothw.data.User;
import ru.gb.lefandoc.springboothw.service.UserService;

import java.security.Principal;
import java.security.Security;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;

    @GetMapping("/auth_page")
    public String authenticatedPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "authenticated";
    }

    @GetMapping("/user_info")
    public String daoTestPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("Unable to find user by username: " + principal.getName()));
        return "Authenticated user info: " + user.getUsername() + " : " + user.getEmail();
    }

}
