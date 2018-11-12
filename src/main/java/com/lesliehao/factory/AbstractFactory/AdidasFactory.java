package com.lesliehao.factory.AbstractFactory;

/**
 * @author HaoHao
 * @date 2018/11/12下午4:38
 */
public class AdidasFactory extends AbstractGarmentFactory {

    @Override
    TShirt produceTShirt() {
        return new AdidasTShirt();
    }

    @Override
    Shoe produceShoe() {
        return new AdidasShoe();
    }

}
