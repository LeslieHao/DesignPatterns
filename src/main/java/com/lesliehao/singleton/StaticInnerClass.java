package com.lesliehao.singleton;

/**
 * DESC: 静态内部类实现单例
 * 与饿汉模式相同，利用了你家在机制创建单例
 * Created by Hh on 2018/1/19
 */
public class StaticInnerClass {

    private static class SingletonHolder{
        public static StaticInnerClass singleInstance = new StaticInnerClass();
    }

    private StaticInnerClass() {
    }

    public static StaticInnerClass newInstance(){
        return SingletonHolder.singleInstance;
    }
}
