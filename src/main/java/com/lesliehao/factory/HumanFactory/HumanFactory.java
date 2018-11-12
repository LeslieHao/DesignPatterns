package com.lesliehao.factory.HumanFactory;

/**
 * DESC:人类梦工厂
 * Created by Hh on 2018/1/19
 */
public class HumanFactory extends AbstractHumanFactory{

    public <T extends Human> T createHuman(Class c) {
        Human human = null;
        try {
            human = (Human) c.getClass().forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) human;
    }
}
