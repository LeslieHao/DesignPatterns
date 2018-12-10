package com.lesliehao.proxy.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB 动态代理
 * 1.字节码技术,通过字节码技术为目标类创建一个子类
 *
 * @author HaoHao
 * @date 2018/12/10下午11:09
 */
public class GamePlayerCGlib implements MethodInterceptor {

    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        return method.invoke(target, objects);
    }
}
