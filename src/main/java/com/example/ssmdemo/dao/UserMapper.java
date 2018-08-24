package com.example.ssmdemo.dao;

import com.example.ssmdemo.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author madengbo
 * @create 2018-08-24 11:18
 * @desc
 * @Version 1.0
 **/
@Repository
public interface  UserMapper {
    public User selectUserByName(int id);
}
