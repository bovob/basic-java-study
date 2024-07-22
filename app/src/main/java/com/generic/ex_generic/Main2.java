package com.generic.ex_generic;

/**
 *  Generic(일반화)
 *
 *  제네릭 메소드도 사용이 가능하다.
 *
 *  (사용법)
 *  [접근제어자] <제네릭타입> [반환타입] [메소드명] ([제네릭타입] [파라미터]){}
 */

// 제네릭 클래스
class ClassName2<E> {

    <T> T genericMethod(T o){
        return o;
    }
}

class Main2 {
    public static void main(String[] args) {

        ClassName2<String> a = new ClassName2<>();

        System.out.println("<T> return : " + a.genericMethod(3));
        System.out.println("<T> return Type : " + a.genericMethod(3).getClass().getName());

        //출력내용
        //<T> return Type : 3
        //<T> return Type : java.lang.Integer

    }
}