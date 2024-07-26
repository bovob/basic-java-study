package com.design_pattern.observer.after.step2;

/**
 *  자동차 시동을 켤 때 호출될 메서드
 *  => 보통 메서드의 이름은 동사로 시작하지만
 *     옵저버에게 통지할 때 호출하는 메서드는
 *     명사구의 형태 이름으로 정의된다.
 */

public interface CarObserver {
    void carStarted();

    void carStopped();
}
