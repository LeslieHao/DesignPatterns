package com.lesliehao.singleton;

/**
 * DESC: 枚举单例
 * 其他三种单例，虽然构造函数私有，但是仍然可以通过反射创建对象，所以只有枚举解决了这个问题，同时也是线程安全的。
 * Created by Hh on 2018/1/19
 */
public enum EnumSingleton {
    /**
     * 枚举编译后代码和常量类类似，
     * 但是继承了Enum 这个类，并置为final
     */

    SINGLETON;
}
