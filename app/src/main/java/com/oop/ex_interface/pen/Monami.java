package com.oop.ex_interface.pen;
/**
 * oop/ex09/f 참조
 */

public class Monami {
    private final String model = "모나미";
    // press(볼펜 누름)을 통해 use가 True를 반환하여 사용한다.
    protected boolean use;

    public String getModel(){
        return model;
    }

    public void press(boolean press){
        this.use = press;
    }

}
