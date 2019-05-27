package com.lesliehao.decorator;

/**
 * 泄压阀
 * @author HaoHao
 * @date 2019-05-27 16:46
 */
public class GolfGTIPressureReliefValve extends Decorator{

    public GolfGTIPressureReliefValve(Car car) {
        super(car);
    }

    @Override
    public void desc() {
        super.desc();
        System.out.println("加装泄压阀~");
    }
}
