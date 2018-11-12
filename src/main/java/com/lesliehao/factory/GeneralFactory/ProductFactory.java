package com.lesliehao.factory.GeneralFactory;

/**
 * DESC: 简单工程模式
 * Created by Hh on 2018/1/19
 */
public class ProductFactory extends AbsProductFactory {

    @Override
    public <T extends BaseProduct> T createProduct(Class<T> c) {
        try {
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static  <T extends BaseProduct> T createProductStatic(Class<T> c) {
        try {
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
