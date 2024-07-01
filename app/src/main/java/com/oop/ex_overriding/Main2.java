package com.oop.ex_overriding;
/** ~/oop/ex06/c 참조
 *
 *  super 와 this
 *
 *  this => 메서드가 소속된 클래스부터 필드를 찾아 올라간다.
 *  super => !!메서드가 소속된!! 클래스의 필드부터 찾아 올라간다.
 *
 */
public class Main2 {
    
    static class A{
        String name = "A";
        int a = 0;

        void printName(){
            System.out.println(name);
        }

        void printInt(){
            System.out.println(a);
        }
    }

    static class B extends A{
        String name = "B";
        float a;

        @Override
        void printName(){
            System.out.println("THIS :" + this.name);
            System.out.println("SUPER :"+ super.name);
        }

        @Override
        void printInt(){
            System.out.println("THIS :" + this.a);
            System.out.println("SUPER :"+ super.a);
        }

        void printName2(){
            System.out.println(name);
        }
    }

    static class C extends B{
        String name = "C";

        @Override
        void printName2(){
            System.out.println("THIS :" + this.name);
            System.out.println("SUPER :"+ super.name);
        }
    }


    public static void main(String[] args) {
        // 1) A를 상속받은 B
        B obj1 = new B();
        // main 메서드 내부 필드에 선언된 test
        obj1.name = "test";
        obj1.printName();       // THIS : test, SUPER : A
        obj1.printInt();        // THIS : 0.0, SUPER : 0


        // 2) B를 상속받은 C
        C obj2 = new C();
        obj2.printName2();      // THIS : C, SUPER B

        System.out.println("---------------------------------");
    }
}
