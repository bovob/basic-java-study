package com.design_pattern.observer.after.step3;

public class SunRoofCarObserver extends AbstractCarObserver {
    // 추상클래스를 상속받아
    // carStartted 클래스를 따로 선언해 둘 필요가 없어졌다.

    @Override
    public void carStopped() {
        System.out.println("썬루프를 닫는다.");
    }
}
