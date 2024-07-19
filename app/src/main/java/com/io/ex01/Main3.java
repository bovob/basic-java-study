package com.io.ex01;

/**
 *  File 클래스
 *  -> 디렉토리 생성하기
 *
 *  (사용법)
 *  File (변수명) = new File("[디렉토리명]");
 *  (변수명).mkdir();
 *
 *  -> 파일생성하기
 *
 *  경로가 존재해야 한다.
 *
 *  (사용법)
 *  File (변수명) = new File("[경로]/[파일명.확장자]");
 *  (변수명).createNewFile();
 */

import java.io.File;

public class Main3 {

    public static void main(String[] args) throws Exception {

        // 디렉토리 생성
        File dir = new File("temp");
        if (dir.mkdir()) {
            System.out.println("temp 디렉토리를 생성하였습니다.");
        } else {
            System.out.println("temp 디렉토리를 생성할 수 없습니다.");
        }

        // 파일 생성
        File file = new File("temp/test.txt");
        if (file.createNewFile()){
            System.out.println("test를 생성하였습니다.");
        } else {
            System.out.println("test를 생성할 수 없습니다.");
        }
    }
}
