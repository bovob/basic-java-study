package com.oop.ex_interface.pen;

/**
 * oop/ex09/f 참조
 */

public class Canvas {
    // Pen 인터페이스를 구현한 객체를 사용한다.
    Pen tool;

    public Canvas(Pen tool){
        this.tool = tool;
    }
    public Pen getTool() {
        return tool;
    }
    public void setTool(Pen tool) {
        this.tool = tool;
    }

    public void render(String contents){
        // Pen 인터페이스의 write를 사용할 수 있게 된다.
        tool.write(contents);
    }
}
