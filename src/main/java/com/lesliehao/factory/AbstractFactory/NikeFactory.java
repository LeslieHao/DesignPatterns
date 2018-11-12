package com.lesliehao.factory.AbstractFactory;

/**
 * @author HaoHao
 * @date 2018/11/12下午4:39
 */
public class NikeFactory extends AbstractGarmentFactory {

    @Override
    TShirt produceTShirt() {
        return new NikeTShirt();
    }

    @Override
    Shoe produceShoe() {
        return new NikeShoe();
    }
}
