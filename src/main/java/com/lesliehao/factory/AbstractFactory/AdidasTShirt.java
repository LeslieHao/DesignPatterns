package com.lesliehao.factory.AbstractFactory;

/**
 * @author HaoHao
 * @date 2018/11/12下午4:33
 */
public class AdidasTShirt implements TShirt {
    @Override
    public void wear() {
        System.out.println("穿上一件阿迪王T恤");
    }
}
