package com.oop.ex_interface.pen;
/**
 * oop/ex09/f 참조
 */

// Monami 는 "상속"받고 Pen 을 "구현" 한다.
public class BallPen153 extends Monami implements Pen{
    // Pen의 write를 무조건 구현 해야한다.
    @Override
    public void write(String text) {
        // Monami 에서 상속받은 Use(boolean)으로 write를 실행한다.
        if (!this.use) return;
        System.out.println("모나미153 쓱싹 "+text);
    }
}
