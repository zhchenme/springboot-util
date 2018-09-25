package com.jas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateCodeApplicationTests {

    @Autowired
	private JedisPool jedisPool;
	
	@Test
	public void contextLoads() {
        System.out.println(jedisPool.getResource());
    }

}
