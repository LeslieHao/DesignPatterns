package com.lesliehao.factory.AbstractFactory;

/**
 * @author HaoHao
 * @date 2018/11/12下午4:30
 */
public class AdidasShoe implements Shoe{

    @Override
    public void wear() {
        System.out.println("穿上一双阿迪王~");
    }
}
