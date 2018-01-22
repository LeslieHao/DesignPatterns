package com.lesliehao.observer;

import org.junit.Test;

/**
 * DESC:
 * Created by Hh on 2018/1/22
 */
public class Client {

    @Test
    public void test(){
        IHanFeiZi hanFeiZi = new IHanFeiZi();
        hanFeiZi.addObserver(new ILiSI());
        hanFeiZi.addObserver(new IZhangSI());
        hanFeiZi.addObserver(new IWangSI());
        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFun();
    }
}
