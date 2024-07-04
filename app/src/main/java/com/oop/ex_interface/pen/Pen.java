package com.oop.ex_interface.pen;

/**
 * oop/ex09/f 참조
 */

// 인터페이스 펜을 생성한다.
// 해당 인터페이스가 참조되어 생성된 개체는
// 쓰기(write)가 가능해진다.

public interface Pen {
    void write(String text);
}
