package com.boot.board_240718.service;

import com.boot.board_240718.model.Role;
import com.boot.board_240718.model.User;
import com.boot.board_240718.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());//패스워드를 암호화
        user.setPassword(encodedPassword);//암호화한 패스워드를 사용자 비밀번호에 넣어줌
        user.setEnabled(true);//enabled를 참으로 저장 > 사용자 활성화

        Role role = new Role();
        //role repository 안만들고, 하드코딩으로 1저장(자동증가)
        role.setId(1L);
        user.getRoles().add(role);

        return  userRepository.save(user);
    }

}
