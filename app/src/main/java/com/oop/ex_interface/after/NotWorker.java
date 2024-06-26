package com.oop.ex_interface.after;

/** 클래스를 정의할 때 Worker 인터페이스를 선언하지 않고
 *  Interface 에 존재하는 메서드를 모두 구현했을 떄
 *  해당 클래스는 Worker 규칙을 따른다고 할 수 없다.
 */

public class NotWorker {
    public void execute(){
        System.out.println("인터페이스 상속하지 않은 Worker");
    }
}
