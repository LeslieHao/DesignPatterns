package com.lesliehao.decorator;

/**
 * 改装车基类
 * @author HaoHao
 * @date 2019-05-27 16:39
 */
public abstract class Decorator implements Car {

    Car car;

    public Decorator(Car car) {
        this.car = car;
    }

    @Override
    public void desc() {
        car.desc();
    }
}
