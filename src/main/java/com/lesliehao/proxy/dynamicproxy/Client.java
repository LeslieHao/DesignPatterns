package com.lesliehao.proxy.dynamicproxy;

import com.lesliehao.proxy.general.IGamePlayer;
import com.lesliehao.proxy.general.Player;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author HaoHao
 * @date 2018/11/12下午6:46
 */
public class Client {

    @Test
    public void test() {

        IGamePlayer player = new Player();

        InvocationHandler invocationHandler = new GamePlayerIH(player);

        ClassLoader classLoader = player.getClass().getClassLoader();

        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, invocationHandler);

        proxy.login();

        proxy.play();

    }
}
