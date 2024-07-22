package com.generic.ex_array;

import com.oop.ex_overloading.B;

/**
 *  제네릭 배열 만들기
 */
public class Main2 {

    public static void main(String[] args) {

        // 선언과 동시에 초기화 가능
        Box<String> box1 = new Box<String>();

        // 초기화 시 파라미터 타입 생략 가능
        Box<String> box3 = new Box<>();

        // 선언 이후 초기화 가능
        Box<String> box2;
        box2 = new Box<String>();

        // 다른 타입으로 초기화 불가능 ! 컴파일 에러
        //box3 = new Box<Object>();
    }

    static class Box<T>{
        void set(T obj){}
    }
}
