package com.lesliehao.decorator;

import org.junit.Test;

/**
 * 汽配城
 * 可以灵活装饰组合,可以多层装饰.被装饰者无感知
 * @author HaoHao
 * @date 2019-05-27 16:50
 */
public class ModificationFactory {

    @Test
    public void modifyCarPlanA(){
        // 买车
        GolfGTI golfGTI = new GolfGTI();
        // 改装卡钳
        GolfGTIBranbo golfGTIBranbo = new GolfGTIBranbo(golfGTI);
        // 刷一阶程序
        GolfGTIOneStage golfGTIOneStage = new GolfGTIOneStage(golfGTIBranbo);

        golfGTIOneStage.desc();
    }
    @Test
    public void modifyCarPlanB(){
        // 买车
        GolfGTI golfGTI = new GolfGTI();
        // 刷一阶程序
        GolfGTIOneStage golfGTIOneStage = new GolfGTIOneStage(golfGTI);
        // 加装泄压阀
        GolfGTIPressureReliefValve golfGTIPressureReliefValve = new GolfGTIPressureReliefValve(golfGTIOneStage);
        golfGTIPressureReliefValve.desc();
    }
}
