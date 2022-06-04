package ru.gb.lefandoc.springboothw.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.gb.lefandoc.springboothw.service.UserService;

@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    private final static String contextPathAuth = "/api/v1/auth";

    private final static String contextPathProducts = "/api/v1/products";

    private final static String contextPathCart = "/api/v1/cart";

//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user2").password(passwordEncoder().encode("pass"))
//                .roles("USER")
//                .authorities("can_get_all");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Dao Authentication Provider");
        http.csrf().disable()
                .authenticationProvider(daoAuthenticationProvider())
                .authorizeRequests()
                .antMatchers(contextPathAuth + "/**").hasRole("ADMIN")
                .antMatchers(contextPathProducts + "/**").hasRole("ADMIN")
                .antMatchers(contextPathCart + "/**").hasRole("ADMIN")
                .antMatchers(contextPathAuth + "/auth_page").hasRole("USER")
                .antMatchers(contextPathAuth + "/user_info").hasRole("USER")
                .antMatchers(contextPathProducts + "/get_all").hasAuthority("can_get_all")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }

}
