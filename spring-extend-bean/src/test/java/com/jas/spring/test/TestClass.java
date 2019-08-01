package com.jas.spring.test;

import com.jas.spring.SpringExtendBeanApplicationTests;
import com.jas.spring.bean.ISuper;
import com.jas.spring.constant.BeanType;
import com.jas.spring.strategy.MyAware;
import com.jas.spring.strategy.MyListener;
import com.jas.spring.strategy.other.MyDispatcher;
import org.junit.Test;

/**
 * Test
 *
 * @author lanxiang
 * @since 2019-08-01
 */
public class TestClass extends SpringExtendBeanApplicationTests {

    @Test
    public void listenerTest() {
        ISuper classA = MyListener.getSuperMap(BeanType.CLASS_A.getBeanType());
        System.out.println(classA);
    }

    @Test
    public void awareTest() {
        ISuper classA = MyAware.getSuperMap(BeanType.CLASS_A.getBeanType());
        System.out.println(classA);
    }

    @Test
    public void dispatcherTest() {
        ISuper classB = MyDispatcher.getSuperMap(BeanType.CLASS_B.getBeanType());
        System.out.println(classB);
    }
}
