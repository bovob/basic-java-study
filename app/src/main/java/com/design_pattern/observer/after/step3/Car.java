package com.design_pattern.observer.after.step3;

import java.util.ArrayList;
import java.util.List;

public class Car {

    List<CarObserver> observers = new ArrayList<>();
    //--------------------------------------------------------------------------------------------------
    // Observer 패턴 적용
    // 자동차의 상태 변경 보고를 받을 Observer
    public void addCarObserver(CarObserver observer){
        observers.add(observer);
    }
    public void removeCarObserver(CarObserver observer){
        observers.remove(observer);
    }
    //--------------------------------------------------------------------------------------------------

    public void start() {
        System.out.println("시동을 건다.");
        //--------------------------------------------------------------------------------------------------
        // Observer 패턴 적용
        for (CarObserver observer : observers){
            observer.carStarted();
        }
        //--------------------------------------------------------------------------------------------------
    }

    public void run() {
        System.out.println("차가 달린다.");
    }

    public void stop() {
        System.out.println("시동을 끈다.");
        //--------------------------------------------------------------------------------------------------
        // Observer 패턴 적용
        for (CarObserver observer : observers){
            observer.carStopped();
        }
        //--------------------------------------------------------------------------------------------------
    }


}
