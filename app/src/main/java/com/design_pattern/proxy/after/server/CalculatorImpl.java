package com.design_pattern.proxy.after.server;

// 실제로 일을 하는 객체로 Calculator 인터페이스를 구현한다.
public class CalculatorImpl implements Calculator {

    @Override
    public int plus(int a, int b) {
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }
}
