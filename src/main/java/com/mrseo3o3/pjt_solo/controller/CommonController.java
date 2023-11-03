package com.mrseo3o3.pjt_solo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/main")
    public void moveToMain() {}

    @GetMapping("/index")
    public void moveToIndex() {}
}
