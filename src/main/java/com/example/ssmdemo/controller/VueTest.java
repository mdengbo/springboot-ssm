package com.example.ssmdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author madengbo
 * @create 2018-08-30 14:45
 * @desc
 * @Version 1.0
 **/
@Controller
@RequestMapping("/vue")
public class VueTest {

    @RequestMapping("/index")
    public String getVue(ModelMap model){
        return "index";
    }

}
