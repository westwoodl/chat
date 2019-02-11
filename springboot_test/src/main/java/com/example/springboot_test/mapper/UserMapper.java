package com.example.springboot_test.mapper;

import com.example.springboot_test.model.User;

import java.util.List;


public interface UserMapper {
    public List<User> findAllUser();
}
