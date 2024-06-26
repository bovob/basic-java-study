package com.oop.ex_interface.after;

/** ~/oop/ex08/a 참조
 */

public class Main2 {

    public static void main(String[] args){

        // 객체 생성 & 생성자 호출을 좀 더 쉽게 할 수 있다.
        Worker w1 = new BlueWorker();
        Worker w2 = new WhiteWorker();
        Worker w3 = new JubuWorker();
        // 인터페이스를 상속받지 않고 메서드를 전부 구현해도
        // 타입 호환성이 맞지 않아 에러가 발생한다.
        //Worker w4 = new NotWorker();

        // 메서드 호출
        w1.execute();
        w2.execute();
        w3.execute();
        //w4.execute();

        // 참고 : 인터페이스 레퍼런스
        Worker w;
        w = new BlueWorker();

        w.execute();
    }

}
