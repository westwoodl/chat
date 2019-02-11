package com.example.springboot_test.controller;

import com.example.springboot_test.model.User;
import com.example.springboot_test.service.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController相当于@Controller和@Response Body
@RestController
@RequestMapping("test")
public class Hello {

    @RequestMapping("hello")
    public String execute(){
        return "hello";
    }

    /**
     * 返回POJO结果
     */
    @RequestMapping("pojo")
    public User showUser(){
        User user = new User();
        user.setId("1");
        user.setName("xuRongChao");
        return user;
    }

    /**
     * 返回list map
     */
    @RequestMapping("maps")
    public List<Map<String, User>> showMap(){
        Map<String, User> maps = new HashMap<>();
        User user = new User();
        user.setId("1");
        user.setName("xuRongChao");
        maps.put("name",user);
        List<Map<String, User>> list = new ArrayList<>();
        list.add(maps);
        list.add(maps);
        return list;
    }

    @Resource
    private UserServiceImpl service;
    /**
     * 整合mybatis
     */
    @RequestMapping("mybatis")
    public List<User> showMybatis(){
        return service.findAllUser();
    }
}
