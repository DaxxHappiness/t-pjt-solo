package com.mrseo3o3.pjt_solo.controller;

import com.mrseo3o3.pjt_solo.domain.dto.UserDto;
import com.mrseo3o3.pjt_solo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class RegisterController {

    private final UserServiceImpl userService;

    @Autowired
    public RegisterController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String registerForm() {
        return "account/registerForm";
    }

    @PostMapping("/user")
    public String registerSubmit(UserDto userDto) {
        // 계정 등록 가능 여부 확인
        if (!registerCheck(userDto.getEmail())) {
            String msg = "MAIL_ALD_EXIST";
            return "redirect:/account/user";
        }
        int rowCnt = this.userService.addUserOne(userDto);
        if (rowCnt != 1) {
            String msg = "ACCOUNT_REG_ERR";
        }
        // 계정 등록 완료 시
        return "redirect:/login";
    }

    private boolean registerCheck(String email) {
        int rowCnt = this.userService.getUserCheck(email);
        return rowCnt == 0;
    }
}
