package com.lesliehao.factory;

import java.lang.reflect.Constructor;

/**
 * DESC: 生成单例的工厂
 * Created by Hh on 2018/1/19
 */
public class SingletonFactory {

    private static Singleton singleton;

    static {
        try {
            Class cls = Class.forName(Singleton.class.getName());
            Constructor con = cls.getDeclaredConstructor();
            con.setAccessible(true);
            singleton = (Singleton) con.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
