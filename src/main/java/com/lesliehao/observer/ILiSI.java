package com.lesliehao.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * DESC:
 * Created by Hh on 2018/1/22
 */
public class ILiSI implements Observer {

    public void update(String  str) {
        System.out.println("李斯观察到：韩非子正在->"+str);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("李斯观察到：韩非子正在->"+arg);
    }
}
