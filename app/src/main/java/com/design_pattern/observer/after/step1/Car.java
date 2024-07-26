package com.design_pattern.observer.after.step1;

import java.util.ArrayList;
import java.util.List;

public class Car {

    // Observer 디자인 패턴 적용 :
    // - publisher 쪽에 추가해야 되는 필드와 메서드
    // - 관찰자(observer/listener/subscriber)의 객체 주소를 보관한다.
    List<CarObserver> observers = new ArrayList<>();

    // 자동차의 상태 변경 보고를 받을 Observer
    public void addCarObserver(CarObserver observer){
        observers.add(observer);
    }

    // 자동차의 상태 변경 보고를 받을 Observer
    public void removeCarObserver(CarObserver observer){
        observers.remove(observer);
    }

    public void start() {
        System.out.println("시동을 건다.");

        for (CarObserver observer : observers){
            observer.carStarted();
        }
    }

    public void run() {
        System.out.println("차가 달린다.");
    }

    public void stop() {
        System.out.println("시동을 끈다.");

        for (CarObserver observer : observers){
            observer.carStopped();
        }
    }


}
