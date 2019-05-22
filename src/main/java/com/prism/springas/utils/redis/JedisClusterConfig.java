package com.prism.springas.utils.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class JedisClusterConfig {

    @Autowired
    private JedisProperties jedisProperties;

    /**
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
     *
     * @return
     */
    @Bean
    public JedisCluster getJedisCluster() {
        //获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
        String[] serverArray = jedisProperties.getClusterNodes().split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        //兼容方案
        if (jedisProperties.getPassword().equals("")) {
            //不需要密码连接的创建对象方式
            return new JedisCluster(nodes, jedisProperties.getCommandTimeout(), 1000, 1, new GenericObjectPoolConfig());
        } else {
            //需要密码连接的创建对象方式
            return new JedisCluster(nodes, jedisProperties.getCommandTimeout(), 1000, 1, jedisProperties.getPassword(), new GenericObjectPoolConfig());
        }
    }
}
