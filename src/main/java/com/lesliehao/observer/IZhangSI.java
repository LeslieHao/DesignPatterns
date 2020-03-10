package com.lesliehao.observer;

/**
 * DESC:
 * Created by Hh on 2018/1/22
 */
public class IZhangSI implements Observer {

    @Override
    public void update(String  str) {
        System.out.println("张斯观察到：韩非子正在->"+str);
    }

}
