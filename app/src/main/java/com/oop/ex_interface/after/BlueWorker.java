package com.oop.ex_interface.after;

/** 인터페이스를 이행하는 클래스는 `구현체` 라 부른다.
 *  구현체 클래스는 반드시 인터페이스에 선언된 모든 메서드를 구현해야 한다.
 *
 *  구현체 정의 규칙
 *  클래스명 implements 인터페이스명 {...인터페이스 선언 메서드...}
 */

public class BlueWorker implements Worker{

    @Override
    public void execute() {
        System.out.println("육체 노동자가 일을 합니다!");
    }

}
