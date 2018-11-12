package com.lesliehao.factory.HumanFactory;

import org.junit.Test;

/**
 * DESC: 女娲
 * Created by Hh on 2018/1/19
 */
public class NvWa {

    @Test
    public void creatHumanTest() {
        HumanFactory humanFactory = new HumanFactory();
        humanFactory.createHuman(YellowHuman.class)
                .getColor()
                .talk();
        humanFactory.createHuman(BlackHuman.class)
                .getColor()
                .talk();
        humanFactory.createHuman(WhiteHuman.class)
                .getColor()
                .talk();
    }
}
