package com.mrseo3o3.pjt_solo.controller;

import com.mrseo3o3.pjt_solo.domain.dto.UserDto;
import com.mrseo3o3.pjt_solo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UserServiceImpl userService;

    @Autowired
    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/main";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "account/loginForm";
    }

    @PostMapping("/login")
    public String loginSubmit(String email, String password, HttpServletRequest request) {
        if (!loginCheck(email, password)) {
            return "redirect:/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("isLogin", true);
        return "main";
    }

    private boolean loginCheck(String email, String password) {
        UserDto user = this.userService.getUserOne(email);
        if (user == null) return false;
        return user.getPassword().equals(password);
    }
}
