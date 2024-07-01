package com.oop.ex_variable;
/** ~/oop/ex06/a 참조
 *
 *  형변환(Type casting)
 *  자바 컴파일러는 레퍼런스가 실제 어떤 인스턴스를 가리키는지 따지지 않고
 *  레퍼런스 타입에 한정하여 인스턴스나 클래스 멤버 사용을 허락한다.
 *
 *  따라서 레퍼런스변수가 실제 가리키는 것이 뭔지 알려줘야 한다.
 *
 *  사용법
 *  ((실제 레퍼런스가 가리키는 인스턴스 타입) 레퍼런스).멤버
 *
 */

public class Main2 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(); // (String) model (int) capacity
        Bike bike = new Bike(); // (boolean) engine
        Car car = new Car();  // (int) cc valve
        Truck truck = new Truck(); // (float) ton (boolean) dump

        // 상위클래스의 래퍼런스로 서브클래스 인스턴스를 가리킬 때
        Car car2 = new Truck();

        car2.model = "티코";  // Vehicle의 인스턴스 변수
        car2.capacity = 5;
        car2.cc = 800;        // Car의 인스턴스 변수
        car2.valve = 16;
        //car2.ton = 123;     // !! Truck의 인스턴스 변수 컴파일 에러
        ((Truck)car2).ton = 5.0f;
        ((Truck)car2).dump = false;

        // 상위클래스의 객체를 강제로 서브클래스로 형변환 하여
        // 컴파일러를 속여도 JVM에서 오류가 발생한다.
        Car car3 = new Truck();
        ((Truck)car3).ton = 100;    // !! 컴파일 에러 발생

        // 다형적 변수를 사용하여 동일한 코드를 가지고 있는 메서드를
        // 한 개의 메서드로 통합할 수 있다.
        truck.model = "봉고";
        truck.cc = 5000;
        car.model = "티코";
        car.cc = 100;
        // 출력 가능
        printCar(truck);
        printCar(car);
    }

    public static void printCar(Car car) {
        System.out.printf("모델명: %s\n", car.model);
        System.out.printf("cc: %d\n", car.cc);
        System.out.println("-------------------------");
    }
}
