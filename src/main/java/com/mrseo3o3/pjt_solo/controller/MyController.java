package com.mrseo3o3.pjt_solo.controller;

import com.mrseo3o3.pjt_solo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    private final UserServiceImpl userService;

    @Autowired
    public MyController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/test")
    public String test(Model model) {
        int rowCnt = this.userService.getUserCount();
        model.addAttribute("userCnt", rowCnt);
        return "index";
    }
}
