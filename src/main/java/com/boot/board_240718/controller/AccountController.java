package com.boot.board_240718.controller;

import com.boot.board_240718.model.User;
import com.boot.board_240718.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    UserService userService;

    //post방식 호출인데 Getmaaping 받음
    @GetMapping("/login")
    public String login(){
        return "/account/login";
    }

    @GetMapping("/register")
    public String register(){//register url로 접근
        return "/account/register";
    }

    @PostMapping("/register")
    public String register(User user){//회원가입 버튼 누르면 정보 가지고 와서 저장
        userService.save(user);

        return "/account/login";
    }
}
