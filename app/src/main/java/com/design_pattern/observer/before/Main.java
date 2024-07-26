package com.design_pattern.observer.before;

/**
 *  ~/design_pattern/observer
 *
 *  기존 코드를 손대지 않거나 최소한으로 손대는 것이 좋다.
 *  기존 코드를 손대지 않고 새 기능을 추가하는 방법 중 하나
 *
 */

public class Main {

    public static void main(String[] args) {
        Car car =  new Car();

        car.start();
        car.run();
        car.stop();

    }
}
