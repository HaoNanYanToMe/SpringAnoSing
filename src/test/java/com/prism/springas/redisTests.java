package com.prism.springas;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.prism.springas.utils.BasePage;
import com.prism.springas.utils.redis.jedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTests {

    private JSONObject json = new JSONObject();

    @Autowired
    jedisUtil jedisUtil;

    @Test
    public void ping() {
//        jedisUtil.delete("haha_haha1");
//        jedisUtil.set("haha_haha","agentVs2",60L);
//        jedisUtil.set("haha_haha1","agentVs233",60L);
//        System.out.println(jedisUtil.get("haha_haha"));
    }

}
