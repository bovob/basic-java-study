package com.oop.ex_interface.after;

/** 인터페이스 정의 규칙
 *  interface 사용규칙명 {...}
 */

public interface Worker {

    // 메서드 생성시 execute를 사용한다.
    // public abstract void execute();
    void execute();

    // 메서드 정의 규칙
    // => public abstract 리턴타입 메서드명 (파라미터);
    // => public 외에 다른 접근 범위는 사용할 수 없다.
    //    이유는 해당 인터페이스의 규칙을 공개해야 하기 때문이다.

    // void test(); 해당 메서드를 주석제거 하면 에러가 발생한다.
}
