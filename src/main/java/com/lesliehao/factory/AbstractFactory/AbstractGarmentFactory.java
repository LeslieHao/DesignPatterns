package com.lesliehao.factory.AbstractFactory;

/**
 * 抽象服装工厂
 * @author HaoHao
 * @date 2018/11/12下午4:35
 */
public abstract class AbstractGarmentFactory {

    abstract TShirt produceTShirt();

    abstract Shoe produceShoe();

}
