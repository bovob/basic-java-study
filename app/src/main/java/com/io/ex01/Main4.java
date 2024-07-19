package com.io.ex01;

/**
 *  File 클래스
 *  -> 디렉토리/파일 삭제하기
 *
 *  (사용법)
 *  File (변수명) = new File("[디렉토리명]");
 *  (변수명).delete();
 */

import java.io.File;

public class Main4 {

    public static void main(String[] args) throws Exception {

        // 파일 삭제
        File file = new File("temp/test.txt");
        if (file.delete()){
            System.out.println("test를 삭제하였습니다.");
        } else {
            System.out.println("test를 삭제할 수 없습니다.");
        }

        // 디렉토리 삭제
        File dir = new File("temp");
        if (dir.delete()){
            System.out.println("temp 디렉토리를 삭제하였습니다.");
        } else {
            System.out.println("temp 디렉토리를 삭제할 수 없습니다.");
        }
    }
}
