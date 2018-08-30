package com.example.ssmdemo.controller;

import com.example.ssmdemo.dao.UserMapper;
import com.example.ssmdemo.domain.User;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author madengbo
 * @create 2018-08-24 11:19
 * @desc
 * @Version 1.0
 **/
@Controller
@RequestMapping("/")
public class UserController {
    //依赖注入
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "cs/{id}")
    @ResponseBody
    public User cs(@PathVariable int id) {
        //调用dao层
        User user = userMapper.selectUserByName(id);
        return user;
    }

    private Logger logger = Logger.getLogger(getClass());
    @Test
    public void test() throws Exception {
        logger.info("输出info");
        logger.debug("输出debug");
        logger.error("输出error");
    }
}
