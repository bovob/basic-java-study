package com.io.ex01;

/**
 *  File 클래스
 *  -> 파일정보 확인방법
 *
 *  (사용법)
 *  File [변수명] = new File("[파일명]");
 *
 */

import java.io.File;

public class Main2 {

    public static void main(String[] args) throws Exception {
        File file1 = new File("/src/main/java/com/io/ex01/Main.java");

        System.out.printf("파일명: %s\n", file1.getName());
        System.out.printf("파일크기: %d\n", file1.length());
        System.out.printf("경로: %s\n", file1.getPath());
        System.out.printf("절대경로: %s\n", file1.getAbsolutePath());
        System.out.printf("계산된 절대경로: %s\n", file1.getCanonicalPath());
    }
}
