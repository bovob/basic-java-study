package com.design_pattern.proxy.after.server;

// 실제 일을 하는 객체와 프록시 객체가 공통으로 따라야 하는 규칙 정의

public interface Calculator {
    int plus(int a, int b);
    int minus(int a, int b);
}
