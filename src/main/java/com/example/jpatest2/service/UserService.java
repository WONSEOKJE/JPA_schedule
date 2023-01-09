package com.example.jpatest2.service;

import com.example.jpatest2.dto.UserRequest;

public interface UserService {

    //유저 등록
    String insertUser(UserRequest userRequest);

    //유저 로그인
    String selectUser(UserRequest userRequest);
}
