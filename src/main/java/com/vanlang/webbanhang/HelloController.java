package com.vanlang.webbanhang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
    @GetMapping("/")
    public String homepage() {
        return "redirect:/products";
    }
}
