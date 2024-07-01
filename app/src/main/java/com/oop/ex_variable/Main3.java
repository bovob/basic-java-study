package com.oop.ex_variable;
/** ~/oop/ex06/a 참조
 *
 *  instanceof 연산자
 *
 *  레퍼런스에 들어있는 주소가 특정 클래스의 인스턴스인지 검사한다.
 *  또는 상위/하위 클래스 인스턴스인지 검사한다.
 *
 *  형변환을 하기전 if로 한 번 확인하도록 한다.
 * 
 * (사용법)
 *  (a instanceof b)
 *   a가 b와
 *   ----------------------------------------------------------------
 *   getClass()
 *
 *   레퍼런스가 가리키는 인스턴스의 실제 클래스정보를 리턴한다.
 *
 * (사용법)
 *  a.getClass()
 *
 */

public class Main3 {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        Truck t = new Truck();

        System.out.println("---Instanceof---");
        System.out.println(v instanceof Vehicle);   //본인 true  대체가능
        System.out.println(v instanceof Car);       //서브 false 대체불가
        System.out.println(v instanceof Bike);
        System.out.println(v instanceof Truck);
        System.out.println("----------------");
        //System.out.println(t instanceof Bike); // 컴파일 에러
        System.out.println(t instanceof Vehicle);   //상위 true 대체가능
        System.out.println(t instanceof Car);

        System.out.println("---getClass()---");
        System.out.println(t.getClass()); // class com.oop.ex_variable.Truck
        //System.out.println(t.getClass() == Vehicle.class);
        System.out.println(t.getClass() == Truck.class); // True

            }
}
