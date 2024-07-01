package com.oop.ex_overriding;
/** ~/oop/ex06/c 참조
 *
 *  super 와 this
 *
 *  this => 메서드가 소속된 클래스부터 필드를 찾아 올라간다.
 *  super => !!메서드가 소속된!! 클래스의 필드부터 찾아 올라간다.
 *
 */
public class Main3 {

    static class A {
        void m() {
            System.out.println("A의 m()");
        }
    }

    static class A2 extends A {

        @Override
        void m() {
            System.out.println("A2의 m()");
        }

        void test() {
            // this 레퍼런스로 메서드를 호출하면,
            // => 인스턴스 클래스(this의 실제 클래스, 예: A4)에서부터 메서드를 찾아 호출한다.
            // => 현재 클래스에 메서드가 없으면 수퍼 클래스에서 메서드를 찾는다.
            // => 메서드를 찾을 때까지 최상위 클래스까지 따라 올라간다.
            this.m();

            // super 레퍼런스로 메서드를 호출하면,
            // => 수퍼 클래스(메서드가 소속된 클래스의 수퍼 클래스, 예: A)에서 메서드를 찾아 호출한다.
            // => 수퍼 클래스에 없으면 그 상위 클래스로 따라 올라간다.
            // => 오버라이딩 하기 전의 메서드를 호출하고 싶을 때 유용하다.
            super.m();
        }
    }

    static class A3 extends A2 {
        @Override
        void m() {
            System.out.println("A3의 m()");
        }
    }

    static class A4 extends A3 {
        @Override
        void m() {
            System.out.println("A4의 m()");
        }
    }

    public static void main(String[] args) {
        A4 obj = new A4();
        obj.test();  // A2의 test() 호출

        // 출력 : A4의 m() A의m()
    }
}
