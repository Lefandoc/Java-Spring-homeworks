package ru.gb.lefandoc.springintrohw.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.gb.lefandoc.springintrohw.Cart;
import ru.gb.lefandoc.springintrohw.service.ProductService;

@Configuration
@ComponentScan("ru.gb.lefandoc.springintrohw")
public class AppConfig {

//    @Bean
//    @Scope("prototype")
//    public Cart cart() {
//        return new Cart();
//    }
}
