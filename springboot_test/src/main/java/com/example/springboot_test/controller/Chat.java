package com.example.springboot_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class Chat {
    List<Map<String, String>> msg;

    public Chat(){
        this.msg = new ArrayList<Map<String, String>>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("who","0");
        map1.put("msg", "快来和我聊天吧");
        this.msg.add(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("who","0");
        map2.put("msg", "快来和我聊天吧！");
        this.msg.add(map2);
    }



    @RequestMapping("send")
    @ResponseBody
    /**
     * 自己发消息
     */
    public List<Map<String, String>> send(String msg, String user){
        Map<String, String> map = new HashMap<>();
        map.put("who", user);
        map.put("msg", msg);
        map.put("time", String.valueOf(new Date()));
        this.msg.add(map);
        return this.msg;
    }

    @RequestMapping("receive")
    @ResponseBody
    /**
     * 查看消息列表
     */
    public List<Map<String, String>> receive(){
        System.out.println(this.msg);
        return this.msg;
    }

    @RequestMapping("chat")
    public String chat(){
        return "chat";
    }
}
