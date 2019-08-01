package com.jas.spring.bean;

import com.jas.spring.constant.BeanType;
import org.springframework.stereotype.Component;

/**
 * ClassB
 *
 * @author lanxiang
 * @since 2019-08-01
 */
@Component
public class ClassB implements ISuper {

    @Override
    public String getType() {
        return BeanType.CLASS_B.getBeanType();
    }
}
