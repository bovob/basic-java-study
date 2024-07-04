package com.oop.ex_interface.car;
/**
 *  oop/ex09/g 참조
 *
 *  Abstract 와 Interface 응용
 */
public class Main {
    public static void main(String[] args) {
        Tico car1 = new Tico();

        // 차량에 대한 점검을 시행한다.
        // 이미 추상화 클래스에서 Interface를 전부 구현했으며
        // Tico 클래스에서 run을 구현하여
        // Tico 생성자를 선언하여 car1 레퍼런스를 통해
        // 해당 인스턴스를 사용할 수 있다.
        if (CarCheckInfo.validate(car1)){
            car1.start();
            car1.run();
            car1.shutdown();
        } else {
            System.out.println("차를 점검해보시기 바랍니다.");
        }
    }
}
