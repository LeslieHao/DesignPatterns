package com.lesliehao.factory.GeneralFactory;

/**
 * DESC:
 * Created by Hh on 2018/1/19
 */
public abstract class AbsProductFactory {

    public abstract <T extends BaseProduct> T createProduct(Class<T> c);
}
