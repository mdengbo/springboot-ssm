package com.example.ssmdemo.TimeAction;

import com.example.ssmdemo.dao.UserMapper;
import com.example.ssmdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 * */
@Component
public class QueryInfo {
    @Autowired
    UserMapper userMapper;
    private  Integer id =2;
    int age = 12;
    int customerid = 123;
    //    启动延迟5秒后，按照每6秒的评率执行
    //@Scheduled(initialDelay = 50000,fixedRate = 6000)
    //每天的22：05 后没两秒执行一次
    @Scheduled(cron ="0/2 5 22 * * ?")
    public void timerToNow(){
        id++;
        User user = new User();
        String username = "zhangsan";

        user.setAge(age++);
        user.setCustomerid(customerid++);
        user.setUsername(username);
        userMapper.insertInfo(user);

        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
