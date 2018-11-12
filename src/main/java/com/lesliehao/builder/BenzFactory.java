package com.lesliehao.builder;

import org.junit.Test;

/**
 * 奔驰工厂
 *
 * @author HaoHao
 * @date 2018/11/12下午5:47
 */
public class BenzFactory {

    @Test
    public void produceA45() {
        CarBuilder carBuilder = new MercedesBenzBuilder();
        A45AMG a45 = (A45AMG) carBuilder.buildChassis()
                .buildEngine()
                .buildExhaust()
                .buildTire()
                .buildTurbine()
                .buildGearbox()
                .buildComplete();
        System.out.println(a45.toString());
    }

}
