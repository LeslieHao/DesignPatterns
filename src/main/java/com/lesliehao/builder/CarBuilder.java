package com.lesliehao.builder;

/**
 * 汽车建造者
 *
 * @author HaoHao
 * @date 2018/11/12下午5:34
 */
public abstract class CarBuilder {

    // 建造底盘
    abstract CarBuilder buildChassis();

    // 安装轮胎
    abstract CarBuilder buildTire();

    // 安装发动机
    abstract CarBuilder buildEngine();

    // 安装变速箱
    abstract CarBuilder buildGearbox();

    // 安装涡轮
    abstract CarBuilder buildTurbine();

    // 安装排气
    abstract CarBuilder buildExhaust();

    // 组装完成
    abstract Car buildComplete();

}
