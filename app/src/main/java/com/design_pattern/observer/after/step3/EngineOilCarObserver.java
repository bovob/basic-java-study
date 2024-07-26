package com.design_pattern.observer.after.step3;

public class EngineOilCarObserver extends AbstractCarObserver {
    // 추상클래스를 상속받아
    // carStopped 클래스를 따로 선언해 둘 필요가 없어졌다.

    @Override
    public void carStarted() {
        System.out.println("출발 전 엔진오일 확인");
    }

}
