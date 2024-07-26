package com.design_pattern.observer.after.step3;

/**
 *  기존에 계속 Observer가 추가될 때 마다
 *  CarObserver(인터페이스)의 메서드를 강제로 전부 구현해야 했다.
 *  ㄴ CarStart & CarStop
 *
 *  하지만 AbstractCarObserver(추상메서드)를 넣음으로써
 *  인터페이스의 클래스를 미리 구현해두어
 *  불필요한 메서드 선언을 하지 않아도 된다.
 */
public abstract class AbstractCarObserver implements CarObserver{
    // 미리 구현해둔다.
    @Override
    public void carStarted() {

    }

    @Override
    public void carStopped() {

    }
}
