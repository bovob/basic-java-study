package com.oop.ex_interface.after;

/** ~/oop/ex08/a 참조
 *
 *  인터페이스를 만나게 되면,
 *  호출자와 피호출자 (caller & callee)를 확인하라.
 */

public class Main {

    public static void main(String[] args){

        // 객체 생성 & 생성자 호출
        BlueWorker w1 = new BlueWorker();
        WhiteWorker w2 = new WhiteWorker();
        JubuWorker w3 = new JubuWorker();

        // 메서드 호출
        w1.execute();
        w2.execute();
        w3.execute();

        // 인터페이스 상속하지 않은 객체 및 생성자
        NotWorker w4 = new NotWorker();

        // 메서드 호출 정상출력
        w4.execute();

    }

}
