package com.lesliehao.observer;

/**
 * DESC: 被观察者
 * Created by Hh on 2018/1/22
 */
public interface Observable {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObservers(String str);

}
