package com.example.jpatest2.service.impl;

import com.example.jpatest2.dto.UserRequest;
import com.example.jpatest2.entity.User;
import com.example.jpatest2.repository.UserRepository;
import com.example.jpatest2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String insertUser(UserRequest userRequest) {
        try {
            userRepository.save(userRequest.toEntity());
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String selectUser(UserRequest userRequest) {

        User user = userRepository.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword()).orElse(null);

        if (user != null) {
            return "success";
        }
        else {
            return "failed";
        }
    }
}
