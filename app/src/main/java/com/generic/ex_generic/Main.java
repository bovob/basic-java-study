package com.generic.ex_generic;
interface InterfaceName<T> {}

/**
 *  Generic(일반화)
 *
 *  클래스 내부에서 지정하는 것이 아닌 외부에서
 *  사용자에 의해 특정 타입(Specific)을 지정하지 않고
 *  필요에 의해 지정할 수 있도록 하는 타입이다.
 *
 *  생성자를 생성할 때 레퍼런스에서
 *  타입 파라미터에 들어갈 값을 지정해 둔다면
 *  생성자에선 생략할 수 있다.
 *
 *  (사용법)
 *  Node<T> nodeT = new Node<>();
 *
 *  주요 타입명
 *  <T> Type
 *  <E> Element
 *  <K> Key
 *  <V> Value
 *  <N> Number
 */

// 제네릭 클래스
class ClassName<E> {

    private E element;	// 제네릭 타입 변수

    void set(E element) {	// 제네릭 파라미터 메소드
        this.element = element;
    }

    E get() {	// 제네릭 타입 반환 메소드
        return element;
    }

}

class Main {
    public static void main(String[] args) {

        ClassName<String> a = new ClassName<String>();
        ClassName<Integer> b = new ClassName<Integer>();

        a.set("10");
        b.set(10);

        System.out.println("a data : " + a.get());
        // 반환된 변수의 타입 출력
        System.out.println("a E Type : " + a.get().getClass().getName());

        System.out.println();
        System.out.println("b data : " + b.get());
        // 반환된 변수의 타입 출력
        System.out.println("b E Type : " + b.get().getClass().getName());

            //출력 내용
            //a data : 10
            //a E Type : java.lang.String
            //
            //b data : 10
            //b E Type : java.lang.Integer

    }
}