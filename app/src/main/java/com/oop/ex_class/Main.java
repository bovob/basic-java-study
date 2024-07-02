package com.oop.ex_class;

/** ~/oop/ex03 참조
 *
 */

public class Main {
    // static 필드 = 클래스 필드(변수)
    // - 클래스를 로딩 할 때 Method Area 영역에 생성된다.
    // - 클래스는 단 한번 로딩된다.
    // - 따라서 스태틱 변수도 한 번만 생성된다.
    // static 변수타입 변수명
    static int a;

    // non-static 필드 = 인스턴스 필드(변수)
    // - new 연산자를 실행할 때 Heap 영역에 생성된다.
    // - new 연산자를 실행할 때 마다 생성된다.
    // - Garbage Collector에 의해 인스턴스가 해제될 때 제거된다.
    // non-static 변수타입 변수명
    int b;

    public static void main(String[] args){

        // 로컬 변수
        // - 메서드가 호출될 때 JVM Stack 영역에 생성된다.
        // - 메서드 호출이 끝나면 제거된다.
        int c;

        /*
            현재시점
            - Method area : a
            - JVM Stack : args, c, obj
            - Heap : 비어있음
         */


        // main을 호출할 때 obj 는 JVM Stack 에 생성되어 있다.
        Main obj;
        obj = new Main();

        System.out.println("a값 출력 : "+ a); // static 은 기본값 0 으로 초기화 되어있다.
        // System.out.println("b값 출력 : "+ b); (에러발생) non-static 은 기본적으로 초기화 되어있지 않다.
        // System.out.println("c값 출력 : "+ c); (에러발생) 로컬 변수는 기본적으로 초기화 되어있지 않다.
        System.out.println("obj값 출력 : "+ obj); // 패키지.클래스@주소값 을 출력한다.
    }
}
