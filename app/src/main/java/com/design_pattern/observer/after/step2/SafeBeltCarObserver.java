package com.design_pattern.observer.after.step2;

public class SafeBeltCarObserver implements CarObserver {

    // 시동을 걸 때 호출되는 메서드
    @Override
    public void carStarted() {
        System.out.println("안전벨트 착용 여부 검사");
    }

    // 시동을 끌 때 호출되는 메서드
    @Override
    public void carStopped() {

    }
}
