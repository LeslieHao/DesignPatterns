package com.lesliehao.proxy.general;

/**
 * 游戏代练
 * @author HaoHao
 * @date 2018/11/12下午6:21
 */
public class ProxyPlayer implements IGamePlayer {

    private IGamePlayer iGamePlayer;

    public ProxyPlayer(IGamePlayer iGamePlayer) {
        this.iGamePlayer = iGamePlayer;
    }

    @Override
    public void login() {
        this.iGamePlayer.login();
    }

    @Override
    public void play() {
        this.iGamePlayer.login();
    }
}
