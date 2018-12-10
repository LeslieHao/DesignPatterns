package com.lesliehao.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK 动态代理
 * @author HaoHao
 * @date 2018/11/12下午6:43
 */
public class GamePlayerJDK implements InvocationHandler {

    //被代理对象
    private Object obj;

    GamePlayerJDK(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用被代理对象的方法
        return method.invoke(this.obj, args);
    }

}
