package com.design_pattern.observer.after.step1;

/**
 *  Observer Main
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
