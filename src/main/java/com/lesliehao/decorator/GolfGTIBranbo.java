package com.lesliehao.decorator;

/**
 * Branbo 卡钳
 * @author HaoHao
 * @date 2019-05-27 16:41
 */
public class GolfGTIBranbo extends Decorator{

    public GolfGTIBranbo(Car car) {
        super(car);
    }

    @Override
    public void desc() {
        super.desc();
        System.out.println("加装Branbo 卡钳");
    }
}
