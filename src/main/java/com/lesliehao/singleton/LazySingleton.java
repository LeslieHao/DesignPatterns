package com.lesliehao.singleton;

/**
 * DESC: 懒汉式
 * Created by Hh on 2018/1/19
 */
public class LazySingleton {

    // volatile 防止指令重排 获取单例失败
    // 指令重排 是指在不改变语义的情况下，通过调整指令的执行顺序，让程序运行更快
    // 所以存在 在对象还未初始化之前，单例就被调用的情况 添加volatile 修饰 保证可见性
    private static volatile LazySingleton singleInstance;

    // 构造函数私有 防止产生多个对象
    private LazySingleton() {
    }

    /**
     * 性能低
     * 每次都进行同步
     * @return
     */
    public static synchronized LazySingleton getLazySingleton1() {
        if (singleInstance == null) {
            singleInstance = new LazySingleton();
        }
        return singleInstance;
    }

    /**
     * 双重检查
     *
     * @return
     */
    public static LazySingleton getLazySingleton() {
        if (singleInstance == null) {
//            // 对象锁
//            synchronized (singleInstance) {
//
//            }
            // 类锁
            synchronized (LazySingleton.class) {
                if (singleInstance == null) {
                    singleInstance = new LazySingleton();
                }
            }
        }
        return singleInstance;
    }

    // 其他方法尽量是 static
    public static void doSomething() {

    }

}
