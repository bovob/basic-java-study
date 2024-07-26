package com.design_pattern.observer.after.step2;

public class EngineOilCarObserver implements CarObserver{

    @Override
    public void carStarted() {
        System.out.println("출발 전 엔진오일 확인");
    }

    @Override
    public void carStopped() {

    }
}
