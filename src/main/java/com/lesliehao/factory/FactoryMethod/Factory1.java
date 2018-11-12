package com.lesliehao.factory.FactoryMethod;

import com.lesliehao.factory.GeneralFactory.BaseProduct;
import com.lesliehao.factory.GeneralFactory.Product1;

/**
 * @author HaoHao
 * @date 2018/11/12下午3:49
 */
public class Factory1 implements Factory {

    @Override
    public BaseProduct produce() {
        return new Product1();
    }
}
