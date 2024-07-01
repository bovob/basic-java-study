package com.oop.ex_variable;
/** ~/oop/ex06/a 참조
 *
 *  다형적 변수
 *
 *  레퍼런스는 같은 타입의 객체를 가리킬 수 있을 뿐만 아니라
 *  클래스의 서브클래스 객체까지 가리킬 수 있다.
 *
 *  - 서버클래스는 항상 자신의 상위 클래스의 모든 것을 사용할 수 있다.
 *  - 따라서 상위클래스의 레퍼런스를 사용하여 그 클래스의 인스턴스 변수를 100% 사용할 수 있다.
 */

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(); // (String) model (int) capacity
        Bike bike = new Bike(); // (boolean) engine
        Car car = new Car();  // (int) cc valve
        Truck truck = new Truck(); // (float) ton (boolean) dump

        // 조상클래스는 서브클래스를 가리킬 수 있다.
        // 이를 "다형적 변수"의 기능을 가지고 있다 한다.
        vehicle = bike;
        vehicle = car;
        vehicle = truck;
        car = truck;

        // !! 같은 조상클래스를 가지고 있더라도
        // 다른 서브클래스의 자식클래스는 호출 불가능
        // bike = truck;

        // 상위클래스의 레퍼런스로 하위클래스 인스턴스를 가리킬 수 있다.
        Vehicle vehicle2 = new Bike();

        // 상위클래스의 필드 사용 가능하다.
        vehicle2.model = "스쿠터";

        // !! 하지만 형식상 상위클래스라 서브클래스의 필드에 접근할 수 없다.
        // vehicle2.engine = "false";

        // !! 컴파일러에는 오류가 뜨지않지만
        // 정상적으로 = new Truck(); 으로 객체를 가르키지 않았기 때문에
        // nullPointException 에러가 발생한다.
        Truck truck2 = null;
        truck2.dump = true;

        // !! 조상클래스 서브클래스 관계더라도
        // 다른 클래스의 인스턴스는 가리킬 수 없다.
        Car car2 = new Car();
        //car2 = vehicle; //컴파일에러

        // 상위클래스의 래퍼런스로 하위클래스 인스턴스를 가리킬 때
        Car car3 = new Truck();

        car3.model = "티코";  // Vehicle의 인스턴스 변수
        car3.capacity = 5;
        car3.cc = 800;        // Car의 인스턴스 변수
        car3.valve = 16;
        // 레퍼런스의 실제 하위 인스턴스를 가리키고 있다고 해도
        // 타입의 범위(실제 레퍼런스는 Car)를 벗어나 사용이 불가능하다.
        //car3.ton = 1;       // Truck의 인스턴스 변수 !! 사용불가
    }
}
