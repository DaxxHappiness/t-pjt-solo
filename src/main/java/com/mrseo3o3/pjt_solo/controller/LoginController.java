package com.mrseo3o3.pjt_solo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "account/loginForm";
    }

    @PostMapping("/submit")
    public String loginSubmit(String email, String password) {
        if (!loginCheck(email, password)) {
            return "redirect:/login";
        }
        return "main";
    }

    private boolean loginCheck(String email, String password) {
        return "test".equals(email) && "1234".equals(password);
    }
}
