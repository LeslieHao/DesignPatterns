package com.lesliehao.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * DESC:
 * Created by Hh on 2018/1/22
 */
public class IHanFeiZi extends Observable implements HanFeiZi  {
//public class IHanFeiZi  implements HanFeiZi, com.lesliehao.observer.Observable {

    List<Observer> observerList = new ArrayList<>();

    public void haveBreakfast() {
        notifyObservers("吃饭");
        super.setChanged();
        super.notifyObservers("开始吃饭啦");
    }

    public void haveFun() {
        notifyObservers("娱乐");
        super.setChanged();
        super.notifyObservers("开始娱乐啦");
    }

//    @Override
//    public void addObserver(Observer observer) {
//        observerList.add(observer);
//    }
//
//    @Override
//    public void deleteObserver(Observer observer) {
//        observerList.remove(observer);
//    }
//
//    @Override
//    public void notifyObservers(String str) {
//        for (Observer o : observerList) {
//            o.update(str);
//        }
//    }
}
