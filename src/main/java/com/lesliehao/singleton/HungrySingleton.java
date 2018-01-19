package com.lesliehao.singleton;

/**
 * DESC: 饿汉式
 * 类加载的时候创建单例，不会存在线程安全问题
 * 但是缺点是单例不需要时也会创建 浪费资源
 * Created by Hh on 2018/1/18
 */
public class HungrySingleton {

    private static volatile HungrySingleton singleton = new HungrySingleton();

    // 构造函数私有 防止产生多个对象
    private HungrySingleton() {
    }

    public static synchronized HungrySingleton getSingleton() {
        return singleton;
    }

    // 其他方法尽量是 static
    public static void doSomething() {

    }

}

