package com.oop.ex_overriding;
/** ~/oop/ex06/c 참조
 *
 *  오버라이딩(Overriding)
 *
 *  (메서드 오버라이딩)
 *  상속 받은 메서드를 서브 클래스의 역할에 맞게 재정의 하는 문법
 *  상속받은 메서드와 똑같은 시그니처(메서드명, 파라미터, 타입/개수/순서)로 정의한다.
 *
 *  (필드 오버라이딩)
 *  변수 타입이 달라도 선언할 수 있다.
 *
 *  주의점
 *  오버라이딩 메서드는 원래의 메서드 보다 접근 범위가 같거나 커야한다.
 *
 * (사용법)
 * @Overriding  어노테이션을 명시하여 컴파일러에게 명시한다.
 * public 기존메소드(기존 파라미터)
 * { 다른 방식의 정의 }
 *
 */
public class Main {
    
    // A는 name tel working을 가진다.
    static class A {
        String name = "A";
        String tel = "A: 010-1111-1111";
        boolean working = true;

        void print() {
            System.out.println("A.print():");
            System.out.printf("  => this.name(%s)\n", this.name);
            System.out.printf("  => this.tel(%s)\n", this.tel);
            System.out.printf("  => this.working(%s)\n", this.working);
        }
    }

    // A2는 age 가 추가되었으며 
    // age 를 출력하는 println 문이 추가되었다.
    static class A2 extends A {

        int age = 20;

        void print2() {
            System.out.println("A2.print2():");
            System.out.printf("  => this.name(%s)\n", this.name);
            System.out.printf("  => this.tel(%s)\n", this.tel);
            System.out.printf("  => this.working(%s)\n", this.working);
            System.out.printf("  => this.age(%s)\n", this.age);
        }

    }

    public static void main(String[] args) {
        // 1) age 필드 추가하기 전
        A obj1 = new A();
        obj1.print(); // name, tel, working 값을 출력한다.
        System.out.println("---------------------------------");

        // 2) age 필드 추가한 후
        A2 obj2 = new A2();
        obj2.print(); // A 클래스의 print() 메서드 호출 : age 필드의 값이 출력되지 않는다.
        System.out.println("---------------------------------");
        
        // A2 클래스의 print2() 메서드 정상출력 된다.
        obj2.print2();
    }
}
