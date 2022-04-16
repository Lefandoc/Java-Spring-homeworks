package ru.gb.lefandoc.springmvchw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.lefandoc.springmvchw.model.Cart;
import ru.gb.lefandoc.springmvchw.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService service;
    private final Cart cart;

    @Autowired
    public CartController(final CartService service,
                          final Cart cart) {
        this.service = service;
        this.cart = cart;
    }

    @GetMapping("/list")
    public String getCart(Model model) {
        model.addAttribute("list", service.lookInCart());
        model.addAttribute("cartSum", cart.fullSum());
        return "cart_list";
    }

    @GetMapping("/put/{id}")
    public String putProduct(Model model, @PathVariable Integer id) {
        model.addAttribute("list", service.lookInCart());
        service.putProduct(id);
        model.addAttribute("cartSum", cart.fullSum());
        return "cart_list";
    }

    @GetMapping("/remove/{id}")
    public String delProduct(Model model, @PathVariable Integer id) {
        model.addAttribute("list", service.lookInCart());
        model.addAttribute("del", service.removeProduct(id));
        model.addAttribute("cartSum", cart.fullSum());
        return "cart_list";
    }

}
