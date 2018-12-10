package com.lesliehao.proxy.dynamicproxy;

import com.lesliehao.proxy.general.IGamePlayer;
import com.lesliehao.proxy.general.Player;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * 1.中介隔离作用
 * 2.开闭原则,增加功能
 * 3.必须要基于接口
 * @author HaoHao
 * @date 2018/11/12下午6:46
 */
public class Client {

    /*
        1.cglib 创建的代理对象比jdk 动态代理创建的代理对象性能要高.但是创建代理对象的过程较慢.
        所以cglib 适用于单例等 少量创建代理对象的情况.
        2.cglib 使用字节码技术创建目标类的子类实现动态代理,所以 final类不能使用cglib
     */


    @Test
    public void testCglib(){
        Player player = new Player();
        GamePlayerCGlib gamePlayerCGlib = new GamePlayerCGlib();
        IGamePlayer gamePlayer = (IGamePlayer) gamePlayerCGlib.getProxy(player);
        gamePlayer.login();
        gamePlayer.play();
    }


    @Test
    public void test() {
        IGamePlayer player = new Player();
        InvocationHandler invocationHandler = new GamePlayerJDK(player);
        ClassLoader classLoader = player.getClass().getClassLoader();
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, invocationHandler);
        proxy.login();
        proxy.play();
    }
}
