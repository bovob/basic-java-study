package com.design_pattern.observer.before;

/**
 * 기존 코드에 계속 새 코드를 추가하는 방식은 유지보수에 좋지 않다.
 *
 * 기존 코드를 손대면서 이미 디버깅/테스트가 끝난 코드를
 * 변경하면 새 버그가 발생할 수 있기 때문이다.
 */

public class Car {
    public void start() {
        // 추가 2
        System.out.println("차량 주변을 확인한다.");

        // 추가 1
        System.out.println("안전벨트를 맨다.");

        System.out.println("시동을 건다.");

    }

    public void run() {
        System.out.println("달린다.");
    }

    public void stop() {
        System.out.println("시동을 끈다.");

        // 추가 1
        System.out.println("안전벨트를 푼다.");
    }
}



