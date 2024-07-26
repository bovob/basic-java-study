package com.design_pattern.observer.after.step3;

public class SafeBeltCarObserver extends AbstractCarObserver {
    // 추상클래스를 상속받아
    // carStopped 클래스를 따로 선언해 둘 필요가 없어졌다.

    @Override
    public void carStarted() {
        System.out.println("안전벨트 착용 여부 검사");
    }
}
