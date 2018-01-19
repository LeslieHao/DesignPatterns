package com.lesliehao.factory.HumanFactory;

/**
 * DESC: 黄种人
 * Created by Hh on 2018/1/19
 */
public class YellowHuman implements Human {

    public Human getColor() {
        System.out.println("黄种人，走在路上，天下知我不一样~");
        return this;
    }

    public Human talk() {
        System.out.println("一身坦荡荡，到四方，五千年终于轮到我上场");
        return this;
    }
}
