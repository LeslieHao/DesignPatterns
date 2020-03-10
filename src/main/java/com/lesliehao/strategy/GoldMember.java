package com.lesliehao.strategy;

/**
 * 黄金会员 打9折
 *
 * @author HaoHao
 * @date 2020/3/10 2:24 下午
 */
public class GoldMember extends AbstractMemberStrategy {

    @Override
    double calPrice(Double originalPrice) {
        return originalPrice * 0.9;
    }

}
