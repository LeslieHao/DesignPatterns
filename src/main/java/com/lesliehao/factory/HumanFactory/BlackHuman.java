package com.lesliehao.factory.HumanFactory;

/**
 * DESC: 黑人
 * Created by Hh on 2018/1/19
 */
public class BlackHuman implements Human{

    public Human getColor() {
        System.out.println("我是小黑黑~~~~");
        return this;
    }

    public Human talk() {
        System.out.println("黑人讲话~~~~~");
        return this;
    }
}
