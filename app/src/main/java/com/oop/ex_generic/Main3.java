package com.oop.ex_generic;

/**
 *  Generic(일반화)
 *
 *  static 에서 사용하기
 *
 */

class ClassName3<E>{

    /*
        클래스와 같은 E 타입이라도
        static 메소드는 객체가 생성되기 이전 시점에
        메모리에 올라가기 때문에
        E 유형을 클래스로부터 얻어올 수 없다.
     */
    // !컴파일 에러
    //static E genericMethod(E o){
    //    return o;
    //}

    private E element;

    // 아래 메소드의 E타입은 제네릭 클래스의 E와 다른 독립적인 타입이다.
    static <E> E genericMethod1(E o){
        return o;
    }

    static <T> T genericMethod2(T o){
        return o;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}

class Main3 {
    public static void main(String[] args) {
        ClassName3<String> a = new ClassName3<String>();

        // 제네릭 메소드1 Integer
        System.out.println("<E> returnType : " + ClassName3.genericMethod1(3).getClass().getName());

        // 제네릭 메소드1 String
        System.out.println("<E> returnType : " + ClassName3.genericMethod1("ABCD").getClass().getName());

        // 제네릭 메소드2 ClassName a
        System.out.println("<T> returnType : " + ClassName3.genericMethod2(a).getClass().getName());

        // 제네릭 메소드2 Double
        System.out.println("<T> returnType : " + ClassName3.genericMethod2(3.0).getClass().getName());
    }
}