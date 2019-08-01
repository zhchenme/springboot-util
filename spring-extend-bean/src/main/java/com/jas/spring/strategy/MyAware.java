package com.jas.spring.strategy;

import com.jas.spring.bean.ISuper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * MyAware
 *
 * @author lanxiang
 * @since 2019-08-01
 */
@Component
public class MyAware implements ApplicationContextAware {

    private static Map<String, ISuper> superMap = new HashMap<>();

    public static ISuper getSuperMap(String beanName) {
        return superMap.get(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ISuper> beansOfType = applicationContext.getBeansOfType(ISuper.class);
        if (null != beansOfType) {
            beansOfType.forEach((k, v) -> superMap.put(v.getType(), v));
        }
    }
}
