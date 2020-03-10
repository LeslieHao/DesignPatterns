package com.lesliehao.strategy;

/**
 * 钻石会员 打8折
 *
 * @author HaoHao
 * @date 2020/3/10 2:24 下午
 */
public class DiamondMember extends AbstractMemberStrategy {


    @Override
    double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }

}
