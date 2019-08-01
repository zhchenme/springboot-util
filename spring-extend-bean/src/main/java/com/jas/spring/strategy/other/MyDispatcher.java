package com.jas.spring.strategy.other;

import com.jas.spring.bean.ISuper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dispatcher
 *
 * @author lanxiang
 * @since 2019-08-01
 */
@Component
public class MyDispatcher implements InitializingBean {
    @Resource
    private BeanManager beanManager;

    private static Map<String, ISuper> superMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        List<ISuper> superList = beanManager.getBeanList(ISuper.class);
        if (!CollectionUtils.isEmpty(superList)) {
            superList.forEach(superClass -> superMap.put(superClass.getType(), superClass));
        }
    }

    public static ISuper getSuperMap(String type) {
        return superMap.get(type);
    }
}
