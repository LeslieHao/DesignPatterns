package com.lesliehao.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * DESC:
 * Created by Hh on 2018/1/22
 */
public class IHanFeiZi implements HanFeiZi, Observable {

    List<Observer> observerList = new ArrayList<>();

    public void haveBreakfast() {
        notifyObservers("吃饭");
    }

    public void haveFun() {
        notifyObservers("娱乐");
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String str) {
        for (Observer o : observerList) {
            o.update(str);
        }
    }
}
