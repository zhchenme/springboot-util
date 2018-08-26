package com.jas;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * @author zchen
 * @description
 * @create 2018-08-26 14:50
 */
public class ShiroTest {
    
    @Test
    public void getPassword() {
        Md5Hash md5 = new Md5Hash("123456", "zchen", 1);
        
        System.out.println(md5.toString());
    }
    
}
