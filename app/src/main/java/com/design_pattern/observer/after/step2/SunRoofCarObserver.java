package com.design_pattern.observer.after.step2;

public class SunRoofCarObserver implements CarObserver{

    @Override
    public void carStarted() {

    }

    @Override
    public void carStopped() {
        System.out.println("썬루프를 닫는다.");
    }
}
