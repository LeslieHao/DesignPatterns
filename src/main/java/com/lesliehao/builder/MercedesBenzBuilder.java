package com.lesliehao.builder;

/**
 * @author HaoHao
 * @date 2018/11/12下午5:39
 */
public class MercedesBenzBuilder extends CarBuilder {

    private A45AMG car = new A45AMG();

    @Override
    CarBuilder buildChassis() {
        car.setChassis("底盘");
        return this;
    }

    @Override
    CarBuilder buildTire() {
        car.setTire("19寸轮毂");
        return this;
    }

    @Override
    CarBuilder buildEngine() {
        car.setEngine("V6");
        return this;
    }

    @Override
    CarBuilder buildGearbox() {
        car.setGearbox("变速箱");
        return this;
    }

    @Override
    CarBuilder buildTurbine() {
        car.setTurbine("双涡轮");
        return this;
    }

    @Override
    CarBuilder buildExhaust() {
        car.setExhaust("大排气");
        return this;
    }

    @Override
    A45AMG buildComplete() {
        return car;
    }

}
