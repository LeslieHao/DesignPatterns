package com.lesliehao.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author HaoHao
 * @date 2018/11/12下午6:43
 */
public class GamePlayerIH implements InvocationHandler {

    //被代理对象
    Object obj;

    public GamePlayerIH(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用被代理对象的方法
        return method.invoke(this.obj, args);
    }

}
