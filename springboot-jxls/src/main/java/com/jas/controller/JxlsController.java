package com.jas.controller;

import com.jas.bean.User;
import com.jas.util.JxlsUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.util.*;

/**
 * @author zc
 * @description
 * @create 2018-08-12 16:15
 */
@Controller
public class JxlsController extends SuperController{
    
    /**
     * 模拟的静态数据
     * 
     * @return
     * @throws ParseException
     */
    private Map<String, Object> getUserList() throws ParseException {
        List<User> userList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(1);
        
        userList.add(new User("Jas", 18, new Date()));
        userList.add(new User("zc", 20, new Date()));
        userList.add(new User("zz", 22, new Date()));
        
        map.put("list", userList);
        
        return map;
    }

    /**
     * 测试的 controller
     * 
     * @return
     * @throws Exception
     */
    @GetMapping("/export")
    public ResponseEntity<byte[]> export()
            throws Exception {
        String source = "test.xls";
        String target = "导出测试.xls";
        String path = JxlsUtils.export(source, target, getUserList());
        return down(target, path);
    }
}
