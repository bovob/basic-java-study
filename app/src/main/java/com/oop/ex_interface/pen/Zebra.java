package com.oop.ex_interface.pen;
/**
 * oop/ex09/f 참조
 */

public class Zebra {
    // 펜의 사용을 int 값으로 받는다.
    // ON / OFF
    public static final int ON =1;
    public static final int OFF =2;
    private static final String model = "지브라";
    boolean use;

    public String getModel(){
        return model;
    }

    // 펜을 돌려 사용하여 rotate라 한다.
    public void rotate(int direction){
        // 펜을 사용한다.
        if(direction == 1)
        {this.use = true;}

        // 펜을 사용하지 않는다.
        else if(direction == 2)
        {this.use = false;}
    }
}
