package com.oop.ex_generic;

import org.checkerframework.checker.units.qual.K;

/**
 *  Generic(일반화)
 *
 *  <A extends B> -> B와 B의 자손타입만 가능 (A는 들어오는 타입으로 지정)
 *  => 상한 경계
 *  <A super B>   -> B와 B의 부모(조상)타입만 가능 (A는 들어오는 타입으로 지정)
 *  => 하한 경계
 *  <?>           -> 모든 타입 가능 ( == <? extends Object> )
 *  => 와일드카드
 */

class E1<K extends Number>{
}

//class E2<V super E1> {
//}

class Main4 {
    public static void main(String[] args) {
        // Number는 Integer, Long, Byte, Double, Float, Short 가능
        E1<Double> e1 = new E1<>();
        // Number의 자손타입이 아닌 String은 ! 컴파일 에러 발생
        //E1<String> e2 = new E1<>();

        //E2<Long> s1 = new E2<>();

    }
}