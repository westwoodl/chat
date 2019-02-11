package com.example.springboot_test.service;

import com.example.springboot_test.mapper.UserMapper;
import com.example.springboot_test.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl {
    @Resource
    private UserMapper dao;


    public List<User> findAllUser() {
        return dao.findAllUser();
    }
}
