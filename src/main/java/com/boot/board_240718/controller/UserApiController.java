package com.boot.board_240718.controller;

import com.boot.board_240718.model.User;
import com.boot.board_240718.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text){
        List<User> users = null;

        if("query".equals(method)){//query가 mothod와 같으면
            users = userRepository.findByUsernameQuery(text);
        }else {//파라미터에 쿼리가 안오면
            users = userRepository.findAll();//전부 조회
        }
        return users;
    }


}
