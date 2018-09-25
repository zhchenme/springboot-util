package com.jas.task;

import com.jas.type.CodeTemplateEnum;
import com.jas.util.JedisClient;
import com.jas.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 定时任务-编码自动生成
 * </p>
 * 
 * @author zchen
 * @create 2018-09-25 15:53
 */
@Component
public class CodeCreateTask {
    private static final Logger logger = LoggerFactory.getLogger(CodeCreateTask.class);
    
    @Autowired
    private JedisClient jedisClient;

    /**
     * 每天凌晨更新编码
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void codeUpdate() {
        // 测试编码随机数
        Long testCode = RandomUtil.getRandomNum4TemplateCode();

        jedisClient.set(CodeTemplateEnum.CODE_TEST.getCode(), testCode.toString());

        logger.info("code task run.");
    }
}
