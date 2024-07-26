package com.design_pattern.observer.after.step2;

/**
 *  Observer Main
 *
 */
public class Main {

    public static void main(String[] args) {
        Car car =  new Car();

        // 새 기능이 포함된 객체를 Publisher(Car)에 등록한다.
        // 기존 Car Class를 손대지 않고 새 기능을 추가한다.
        // Observer 패턴으로 구조화 시킨 이유이다.


        car.addCarObserver(new SafeBeltCarObserver());
        car.addCarObserver(new EngineOilCarObserver());
        car.start();

        car.run();

        car.addCarObserver(new SunRoofCarObserver());
        car.stop();
    }
}
