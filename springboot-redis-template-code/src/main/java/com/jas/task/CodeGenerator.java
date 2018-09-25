package com.jas.task;

import com.jas.type.CodeTemplateEnum;
import com.jas.util.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 通过定时任务对编码进行统一管理
 * </p>
 * 
 * @author zchen
 * @create 2018-09-25 15:49
 */
@Component
public class CodeGenerator {
    @Autowired
    private JedisClient jedisClient;

    /**
     * 获取测试编码
     * 
     * @return
     */
    public String getTestCode() {
        return jedisClient.incr(CodeTemplateEnum.CODE_TEST.getCode()).toString();
    }
}
