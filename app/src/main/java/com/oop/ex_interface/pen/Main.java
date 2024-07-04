package com.oop.ex_interface.pen;

/**
 * oop/ex09/f 참조
 */

public class Main {

    public static void main(String[] args) {
        // 모나미를 상속받고 펜을 구현한
        // Ballpen의 pen1 레퍼런스를 선언하고
        // 생성자를 호출하여 새 인스턴스를 생성한다.
        BallPen153 pen1 = new BallPen153();

        // Canvas의 c1 레퍼런스를 선언하고
        // 생성자를 호출할 때 파라미터 값으로 받을 Tool인 pen1 레퍼런스를 넘겨준다.
        Canvas c1 = new Canvas(pen1);

        // 아직 press(사용)가 false 다.
        c1.render("펜으로 쓴것");

        // Boolean 값을 True 로 둠으로써
        // Pen 사용으로 write 메서드를의 반환값을 print문 까지 넘긴다.
        pen1.press(true);

        // Canvas의 render를 출력한다.
        c1.render("펜으로 쓴것");

        //Zebra를 상속받고 펜을 구현한
        // Multipen의 pen2 레퍼런스를 선언하고
        // 생성자를 호출하여 새 인스턴스를 생성한다.
        MultiPen pen2 = new MultiPen();
        
        // 현재 사용중인 펜 확인
        System.out.println("현재 사용중인 펜은 : " + (((BallPen153)c1.getTool()).getModel()));
        
        // Canvas의 Pen을 변경한다.
        System.out.println("펜을 변경합니다.");
        c1.setTool(pen2);
        
        // 현재 사용중인 펜 확인
        System.out.println("현재 사용중인 펜은 : " + ((MultiPen)c1.getTool()).getModel());
        
        // ON 값을 넘김으로써
        // Pen 사용으로 write 메서드를 반환하여 print문 까지 넘긴다.
        pen2.rotate(Zebra.ON);
        
        // Canvas의 render를 출력한다.
        c1.render("펜으로 쓴것");

    }

}
