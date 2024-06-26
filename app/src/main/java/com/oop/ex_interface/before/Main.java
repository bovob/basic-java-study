package com.oop.ex_interface.before;

/** ~/oop/ex08/a 참조
 */

public class Main {

    public static void main(String[] args){

        // 객체 생성 & 생성자 호출
        BlueWorker w1 = new BlueWorker();
        WhiteWorker w2 = new WhiteWorker();
        JubuWorker w3 = new JubuWorker();

        // 메서드 호출
        w1.doFight();
        w2.doZingZing();
        w3.doSsingSsing();

        /* 이처럼 worker를 추가로 제작할 경우 메서드와 파라미터 형식이 달라지게 된다.
           따라서 유사한 일을 하는 객체에 대한 사용법을 통일해야 한다.

           => 객체 사용 규칙을 정의한다.
           => 클래스를 정의할 때 규칙에 따라 만들 수 있도록 한다.

           따라서, 규칙에 따라 만들어진 클래스에서 일관된 메서드를 호출할 수 있어
           코딩이 편해지며 유지보수가 쉬워진다.

           이를 객체의 사용 규칙을 정의하는 `인터페이스(interface)` 라 한다.

         */

    }

}
