package com.lesliehao.factory.AbstractFactory;

/**
 * @author HaoHao
 * @date 2018/11/12下午4:34
 */
public class NikeTShirt implements TShirt {

    @Override
    public void wear() {
        System.out.println("穿上一件NikeT恤");
    }

}
