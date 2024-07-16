package com.oop.ex_lambda;
/**
 *  스태틱 메서드 레퍼런스
 *
 *  람다 :: 활용
 *
 *  기존 작성한 클래스의 스태틱 메서드를
 *  람다 구현체 를 활용하여 사용할 수 있다.
 *
 *  규격?
 *  메서드의 파라미터 타입 / 갯수 / 순서, 리턴 타입
 *
 *  (사용법)
 *  클래스명 :: 메서드명
 *
 */

public class Main6 {

    public static void main(String[] args) {

        // 익명 클래스 사용
        Calculator o1 = new Calculator() {
            @Override
            public int compute(int x, int y) {
                return x + y;
            }
        };

        // 람다 사용
        Calculator o2 =  (x, y) -> x + y;

        // 기존 익명클래스 + 람다 사용
        System.out.println(o1.compute(20, 10));
        System.out.println(o2.compute(20, 10));

        // static 메서드의 람다 구현체 활용
        Calculator c1 = MyCalculator::plus;
        System.out.println(c1.compute(20,10));

        // 파라미터 갯수가 같지 않아 컴파일 에러 발생
        //Calculator c2 = MyCalculator::plus3;
        //method plus3 in class MyCalculator cannot be applied to given types
        //    required: int,int,int
        //found:    int,int
        //reason: actual and formal argument lists differ in length

        // 파라미터 타입이 같지 않아 컴파일 에러 발생
        //DoubleCalculator d1 = MyCalculator::divide;
        //incompatible types: possible lossy conversion from double to int

        // Static 클래스와 인터페이스의 리턴타입이 같지 않아 컴파일 에러 발생
        //StrCalculator m1 = MyCalculator::divide;
        //float cannot be converted to int

    }
    
    // 인터페이스
    interface Calculator{
        int compute(int x, int y);
    }

    interface DoubleCalculator{
        int compute(double x, double y);
    }

    interface StrCalculator{
        Short compute(int x, int y);
    }


    // Statiac 클래스
    static class MyCalculator{
        public static int plus(int a, int b) { return a + b;}
        public static int minus(int a, int b) { return a - b;}
        public static int multiple(int a, int b) { return a * b;}
        public static float divide(int a, int b) { return a / b;}

        public static int plus3(int a, int b, int c) { return a + b + c;}
    }

}
