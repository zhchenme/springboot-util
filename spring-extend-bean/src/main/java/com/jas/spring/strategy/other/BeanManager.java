package com.jas.spring.strategy.other;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BeanManager
 *
 * @author lanxiang
 * @since 2019-08-01
 */
@Component
public class BeanManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    public <T> List<T> getBeanList(Class<T> clazz) {
        Map<String, T> beanMap = applicationContext.getBeansOfType(clazz);
        return new ArrayList<>(beanMap.values());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
