package com.lesliehao.factory.HumanFactory;

/**
 * DESC: 白种人
 * Created by Hh on 2018/1/19
 */
public class WhiteHuman implements Human {

    public Human getColor() {
        System.out.println("我是小白白~~~");
        return this;
    }

    public Human talk() {
        System.out.println("Can u speak English ?");
        return this;
    }
}
