package com.lesliehao.factory.GeneralFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * DESC: 带缓存容器的工厂
 * Created by Hh on 2018/1/19
 */
public class DelayProductFactory {

    private static final Map<String, BaseProduct> map = new HashMap<>();

    public static synchronized BaseProduct createProduct(String type) {
        BaseProduct product = null;
        if (map.containsKey(type)) {
            product = map.get(type);
        } else {
            switch (type) {
                case "Product1":
                    product = new Product1();
                    break;
                case "Product2":
                    product = new Product2();
                    break;
            }
            map.put(type, product);
        }
        return product;
    }
}
