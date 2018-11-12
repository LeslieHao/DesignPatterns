package com.lesliehao.proxy.general;

/**
 * @author HaoHao
 * @date 2018/11/12下午6:19
 */
public class Player implements IGamePlayer {

    @Override
    public void login() {
        System.out.println("登录游戏~");
    }

    @Override
    public void play() {
        System.out.println("打怪升级~");
    }
}
