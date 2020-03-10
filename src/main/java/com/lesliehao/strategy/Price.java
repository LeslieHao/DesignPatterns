package com.lesliehao.strategy;

/**
 * @author HaoHao
 * @date 2020/3/10 2:26 下午
 */
public class Price {

    private AbstractMemberStrategy strategy;

    public Price(AbstractMemberStrategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(Double price) {
        return strategy.calPrice(price);
    }
}
