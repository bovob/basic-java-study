package com.oop.ex_lambda;
/**
 *  파라미터가 2개 이상일 때
 */
interface Calculator{
    int plus(int a, int b);
}

public class Main2 {

    public static void main(String[] args) {
        //1)일반
        class MyCalc implements Calculator{
            @Override
            public int plus(int a, int b) {
                return a + b;
            }
        }
        Calculator c1 = new MyCalc();
        test(c1);

        //2)익명
        Calculator c2 = new Calculator() {
            @Override
            public int plus(int a, int b) {
                return a + b;
            }
        };
        test(c2);

        //3)익명직접
        test(new Calculator() {
            @Override
            public int plus(int a, int b) {
                return a+b;
            }
        });

        //4)람다
        Calculator c4 = (int a, int b) -> { return (a+b);};
        test(c4);

        //5)람다생략
        // 파라미터 타입과 { } 는 제거할 수 있다.
        // { } 제거시 return 은 필수로 제거해야 한다.
        Calculator c5 = (a, b)  -> a + b;
        test(c5);

        //6)람다직접
        // return 마지막 ; 까먹지 말 것
        test((int a, int b) -> {return (a + b);});

        //7)람다직접생략
        test((a, b) -> a + b);
    }


    static void test (Calculator c){
        System.out.println(c.plus(100, 200));
    }
}
