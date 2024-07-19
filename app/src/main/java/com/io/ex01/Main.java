package com.io.ex01;

import java.io.File;

/**
 *  ~/io/ex01 참조
 *
 *  File 클래스
 *  -> 디렉토리나 파일을 다룰 때 사용하는 클래스이다.
 *  -> 디렉토리나 파일을 생성, 삭제, 변경 할 수 있다.
 *
 *  현재 디렉토리 조회
 *  -> JVM을 실행하는 위치가 현재 폴더 ('.') 이다.
 *  -> 이클립스 : 프로젝트 디렉토리 ('.')를 가리킨다.
 *  -> 콘솔 : 현재 명령어를 실행하는 위치 가리킨다.
 *
 *  (사용법)
 *  File [변수명] = new File("[pathname]");
 */

public class Main {

    public static void main(String[] args) throws Exception{
        File currentDir = new File("app");
        System.out.printf("폴더명 : %s\n", currentDir.getName());
        System.out.printf("경로 : %s\n", currentDir.getPath());
        // 경로차이
        // ~최상위/.(현재위치)/하위
        // ~최상위/하위
        System.out.printf("절대경로 : %s\n", currentDir.getAbsolutePath());
        System.out.printf("계산된 절대경로 %s\n", currentDir.getCanonicalPath());
        //                                                              KB    MB   GB
        System.out.printf("총크기: %d GB\n", currentDir.getTotalSpace()/1024 /1024 /1024);
        System.out.printf("남은크기: %d GB\n", currentDir.getFreeSpace()/1024 /1024 /1024);
        System.out.printf("가용크기: %d GB\n", currentDir.getUsableSpace()/1024 /1024 /1024);

        System.out.printf("디렉토리여부: %b\n", currentDir.isDirectory());
        System.out.printf("파일여부: %b\n", currentDir.isFile());
        System.out.printf("감춤폴더: %b\n", currentDir.isHidden());
        System.out.printf("존재여부: %b\n", currentDir.exists());
        System.out.printf("실행가능여부: %b\n", currentDir.canExecute());

    }

}
