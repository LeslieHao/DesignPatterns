package com.lesliehao.factory.GeneralFactory;

import org.junit.Test;

/**
 * DESC: 工厂模式优点：
 * 良好的封装性，代码结构清晰
 * 扩展性优秀，添加产品过程简单，只需添加一个产品类，其他类均不用做修改
 * 屏蔽产品类，调用者不用关心产品如何实现
 * Created by Hh on 2018/1/19
 */
public class Producer {

    @Test
    public void produce(){
        ProductFactory factory = new ProductFactory();
        factory.createProduct(Product1.class).m2();
        factory.createProduct(Product2.class).m2();

        //静态工厂模式
        ProductFactory.createProductStatic(Product1.class).m2();

    }

}
