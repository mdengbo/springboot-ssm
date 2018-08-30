package com.example.ssmdemo.service;

import com.example.ssmdemo.cache.JedisUtil;
import com.example.ssmdemo.dao.AreaDao;
import com.example.ssmdemo.domain.Area;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author madengbo
 * @create 2018-08-27 14:26
 * @desc
 * @Version 1.0
 **/
public class TransactionManager {

    @Autowired
    private JedisUtil.Strings jedisStrings;


    // Redis的安装和配置      启动之后再来运行这个是可以的  也就是走缓存了
    //    https://www.jianshu.com/p/6b5eca8d908b


    @Autowired
    private JedisUtil.Keys jedisKeys;

    @Autowired
    private AreaDao areaDao;

    private static String AREALISTKEY = "arealist";

    public List<Area> getAreaList() throws IOException {
        String key = AREALISTKEY;
        List<Area> areaList = null;
        ObjectMapper mapper = new ObjectMapper();
        //判断是否有缓存
        if (!jedisKeys.exists(key)) {
            //没哟缓存  则查询数据库
            areaList = areaDao.queryArea();
            String jsonString = mapper.writeValueAsString(areaList);
            jedisStrings.set(key, jsonString);
        } else {
            //有缓存  这个时候从缓存中通过key获取到缓存的数据  然后转换为我们需要的数据
            String jsonString = jedisStrings.get(key);
            JavaType javaType = mapper.getTypeFactory()
                    .constructParametricType(ArrayList.class, Area.class);
            areaList = mapper.readValue(jsonString, javaType);
        }
        return areaList;
    }
}
