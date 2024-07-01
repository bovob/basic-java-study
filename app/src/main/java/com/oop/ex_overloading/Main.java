package com.oop.ex_overloading;
/** ~/oop/ex06/b 참조
 *
 *  메서드 오버로딩(Overloading)
 *
 *  파라미터 형식(타입과 갯수)이 다르더라도
 *  같은 기능을 수행하는 메서드에 대해 같은 이름을 부여한다.
 *  따라서 프로그램의 일관성을 제공할 수 있다.
 * 
 * (사용법)
 *  method name(파라미터 값){}
 *  method name(파라미터 값, 파라미터값){}
 *  method name(파라미터 다른타입의 값){}
 */


public class Main {

    static class Calculator {

        // 같은 이름의 메서드를 2개 정의한다.
        // 하지만 받는 파라미터는 다르다.
        static int plus(int a, int b){
            return a + b;
        }
        static int plus(int a){
            return a + a;
        }
    }

    public static void main(String[] args) {
        int result1 = Calculator.plus(100, 200);
        int result2 = Calculator.plus(100);

        System.out.println("result 1: "+result1+", result 2: "+result2);

        // B는 상위클래스인 A의 m()을 모두 쓸 수 있다.
        // A는 하위클래스인 B에서 오버로딩한 m(int,int,int)를 쓸 수 없다.
        A.m();
        //A.m(100,200,300); //컴파일에러
        B.m();
        B.m(100);
        B.m(100,200,300);
    }
}
