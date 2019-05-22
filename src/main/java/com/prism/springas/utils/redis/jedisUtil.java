package com.prism.springas.utils.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.prism.springas.utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;

//Jedis工具类
@Component
public class jedisUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(jedisUtil.class);

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 设置缓存
     *
     * @param key          缓存key
     * @param value        缓存value
     * @param expireSecond 失效时间
     */
    public void set(String key, String value, Long expireSecond) {
        boolean keyExist = jedisCluster.exists(key);
        // NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
        if (keyExist) {
            jedisCluster.del(key);
        }
        jedisCluster.set(key, value, "NX", "EX", expireSecond);
        LOGGER.debug("RedisUtil:set cache key={},value={}", key, value);
    }

    /**
     * 设置缓存对象
     *
     * @param key 缓存key
     * @param obj 缓存value
     */
    public <T> void setObject(String key, T obj, int expireTime) {
        jedisCluster.setex(key, expireTime, JSON.toJSONString(obj));
    }

    /**
     * 获取指定key的缓存
     *
     * @param key---JSON.parseObject(value, User.class);
     */
    public String getObject(String key) {
        return jedisCluster.get(key);
    }

    /**
     * 判断当前key值 是否存在
     *
     * @param key
     */
    public boolean hasKey(String key) {
        return jedisCluster.exists(key);
    }


    /**
     * 设置缓存，并且自己指定过期时间
     *
     * @param key
     * @param value
     * @param expireTime 过期时间
     */
    public void setWithExpireTime(String key, String value, int expireTime) {
        jedisCluster.setex(key, expireTime, value);
        LOGGER.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", key, value, expireTime);
    }


    /**
     * 获取指定key的缓存
     *
     * @param key
     */
    public String get(String key) {
        String value = jedisCluster.get(key);
        LOGGER.debug("RedisUtil:get cache key={},value={}", key, value);
        return value;
    }

    /**
     * 将获取的对象转换成后台可以辨识的BasePage数据对象
     *
     * @param key
     * @return
     */
    public List<BasePage> getBaseList(String key) {
        if (this.getObject(key) != null) {
            JSONArray jsonArray = JSONArray.parseArray(this.getObject(key));
            List<BasePage> list = new ArrayList<>();
            if (jsonArray.size() > 0) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    BasePage reven = new BasePage();
                    JSONObject jo = jsonArray.getJSONObject(i);
                    for (String Jkey : jo.keySet()) {
                        reven.put(Jkey, jo.get(Jkey));
                    }
                    list.add(reven);
                }
            }
            return list;
        } else {
            return null;
        }
    }

    /**
     * 删除指定key的缓存
     *
     * @param key
     */
    public void delete(String key) {
        jedisCluster.del(key);
        LOGGER.debug("RedisUtil:delete cache key={}", key);
    }
}
