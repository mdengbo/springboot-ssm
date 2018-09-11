package com.example.ssmdemo;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
@EnableScheduling//开启定时任务
@MapperScan("com.example.ssmdemo.dao")
public class SsmdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmdemoApplication.class, args);
    }
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void test() throws Exception {
        logger.info("输出info");
        logger.debug("输出debug");
        logger.error("输出error");
    }
}
