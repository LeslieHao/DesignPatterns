package com.lesliehao.strategy;

/**
 * 策略之前相互替换,相互独立
 *
 * @author HaoHao
 * @date 2020/3/10 2:22 下午
 */
public abstract class AbstractMemberStrategy {

    /**
     * 计算会员价格
     *
     * @param originalPrice
     * @return
     */
    abstract double calPrice(Double originalPrice);

}
