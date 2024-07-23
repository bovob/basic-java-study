package com.io.ex02;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *   io/ex01/~520
 *
 *  1. 디렉터리 생성
 *
 *  2. 파일 생성
 *
 *  3. 디렉터리 미리 생성 후 파일 생성
 *  
 *  4. 폴더 정보 알아내기
 *
 *  5. 디렉터리 내 파일 정보 알아내기
 */

public class Main {

    // Line
    public static void Line(){
        final String LINE = "----------------------------------------";
        System.out.println(LINE);
    }

    public static void main(String[] args) throws IOException {

        // 디렉터리 정보 확인
        String pwd = System.getProperty("user.dir");
        System.out.printf("현재 경로 \n ㄴ %s\n", pwd);


        // 1. temp Dir 생성
        //File dir = new File("temp");
        //if (dir.mkdir()){
        //    System.out.println("temp 디렉터리 생성");
        //} else {
        //    System.out.println("temp 디렉터리 생성불가");
        //}
        // temp Dir 삭제
        //if (dir.delete()){
        //    System.out.println("temp 디렉터리 삭제");
        //} else {
        //    System.out.println("temp 디렉터리 삭제불가");
        //}

        Line();
        // 현재 파일 위치 + 생성 디렉터리
        //String tmpPath = pwd+"/"+dir;

        // 2. 파일 생성
        //File file1 = new File (tmpPath+"/test.txt");
        //
        //System.out.println(tmpPath);
        //if (file1.createNewFile()){
        //    System.out.println("test 파일 생성");
        //} else {
        //    System.out.println("test 파일 생성불가");
        //}
        //// temp Dir 삭제
        //if (file1.delete()){
        //    System.out.println("test 파일 삭제");
        //} else {
        //    System.out.println("test 파일 삭제불가");
        //}

        Line();

        // 3. 디렉터리 생성 후 파일 생성
        File file2 = new File("temp/io/test.txt");
        File path2 = file2.getParentFile();
        // 파일 디렉터리 확인
        System.out.println(path2);
        // 디렉터리 생성 mkdirs(하위 디렉터리까지)
        if(path2.mkdirs()){
            System.out.println("디렉터리 생성");
            // 파일 생성
            if (file2.createNewFile()){
                System.out.println("파일 생성");
            } else {
                System.out.println("파일 생성실패");
            }
        } else {
            System.out.println("디렉터리 생성실패");
        }

        Line();

        // 4. 폴더 내 파일 확인
        String[] dirList = path2.list();
        for (String name : dirList){
            System.out.println(name);
        }

        Line();

        // 5. 파일 정보 확인
        File[] files = path2.listFiles();
        for (File file : files){
            System.out.printf("%s %6s %12d %s\n",
                file.isDirectory() ? "d" : "-",     // 디렉터리 d 파일 -
                new Date(file.lastModified()),      // 마지막 수정 날짜
                file.length(),                      // 크기
                file.getName()                      // 이름
                );
        }
    }
}
