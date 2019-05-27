package com.lesliehao.decorator;

/**
 * 刷一阶
 * @author HaoHao
 * @date 2019-05-27 16:41
 */
public class GolfGTIOneStage extends Decorator{

    public GolfGTIOneStage(Car car) {
        super(car);
    }

    @Override
    public void desc() {
        super.desc();
        System.out.println("刷了一阶程序,马力提升50匹");
    }
}
