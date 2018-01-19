package com.lesliehao.factory.HumanFactory;

/**
 * DESC: 抽象人类工厂
 * Created by Hh on 2018/1/19
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T creatHuman(Class c);
}
