package com.io.ex02;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 *   io/ex01/
 *
 *  FilenameFilter 익명 클래스로 필터 하나만 생성하기
 *  
 *  1. 익명
 *  2. 람다
 *  3. 생략
 */

public class Main3 {

    // Line
    public static void Line(){
        final String LINE = "----------------------------------------";
        System.out.println(LINE);
    }

    public static void main(String[] args) throws IOException {

        // 0. 더미 파일 생성
        String[] fileExtention = new String[]{"txt", "jpg", "java", "c", "py", "yml"};
        File dummyPath = new File("temp/dummy/");
        String dummyFileName = "test";


        // 디렉터리 생성 mkdirs(하위 디렉터리까지)
        if(!dummyPath.exists()){
            dummyPath.mkdirs();
            System.out.println("디렉터리 생성");
        }
            // 파일 생성
            for (String ext : fileExtention){
                File dummyFiles = new File(dummyPath,dummyFileName + "." + ext);
                System.out.println(dummyFiles);
                try {
                    if(dummyFiles.createNewFile()){
                        System.out.println("Create Success : " + dummyFiles.getAbsolutePath());
                    } else {
                        System.out.println("Create Fail : " + dummyFiles.getAbsolutePath());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        Line();

        // 0. 필터 생성
        //FileFilter javaFilter = new FileFilter(){
        //    @Override
        //    public boolean accept(File file) {
        //        return file.isFile() && file.getName().endsWith(".java");
        //    }
        //};


        //// 1. 파일 위치 및 리스트 배열 만들기
        //File path = new File("temp/dummy/");
        //File[] files = path.listFiles(javaFilter);
        //// 2. 목록 가져오기
        //for (File name : files){
        //    System.out.printf("%12d %s\n",
        //        name.length(),                  // 크기
        //        name.getName());                // 이름
        //}


        // Lambda
        // 1. 파일 위치 및 리스트 배열 만들기
        //File path = new File("temp/dummy/");
        //File[] files = path.listFiles(
        //    file -> {return file.isFile() && file.getName().endsWith(".java");}
        //);
        //// 2. 목록 가져오기
        //for (File name : files){
        //    System.out.printf("%12d %s\n",
        //        name.length(),                  // 크기
        //        name.getName());                // 이름
        //}

        // Lambda
        // 1. 파일 위치 및 리스트 배열 만들기
        File path = new File("temp/dummy/");
        File[] files = path.listFiles(
            file -> file.isFile() && file.getName().endsWith(".java")
        );
        // 2. 목록 가져오기
        for (File name : files){
            System.out.printf("%12d %s\n",
                name.length(),                  // 크기
                name.getName());                // 이름
        }
    }
}
