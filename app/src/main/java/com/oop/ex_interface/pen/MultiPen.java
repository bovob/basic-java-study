package com.oop.ex_interface.pen;
/**
 * oop/ex09/f 참조
 */

public class MultiPen extends Zebra implements Pen{
    @Override
    public void write(String text) {
        // 펜의 사용을 boolean 값으로 받아
        // print를 출력한다.
        if(!this.use) return;
        System.out.println("지브라로 쓱싹 " + text);
    }
}
