package com.jas.spring.strategy;

import com.jas.spring.bean.ISuper;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * MyListener
 *
 * @author lanxiang
 * @since 2019-08-01
 */
@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {

    private static Map<String, ISuper> superMap = new HashMap<>();

    public static ISuper getSuperMap(String beanName) {
        return superMap.get(beanName);
    }

    // TODO 根据业务类型，可作处理中心

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (null == event.getApplicationContext().getParent()) {
            Map<String, ISuper> beansOfType = event.getApplicationContext().getBeansOfType(ISuper.class);
            if (null != beansOfType) {
                beansOfType.forEach((k, v) -> superMap.put(v.getType(), v));
            }
        }
    }
}
