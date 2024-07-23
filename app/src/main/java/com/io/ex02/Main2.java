package com.io.ex02;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

/**
 *   io/ex01/
 *
 *   FilenameFilter 이용하기
 */

public class Main2 {

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

        // 1. Filter
        // Filename Filter 인터페이스를 상속받는다.
        class JavaFilter implements FilenameFilter {

            // 메서드 재정의
            @Override
            public boolean accept(File dir, String name) {
                // 디렉터리 | 파일 확인을 위하여 객체 생성
                File file = new File(dir, name);
                // 파일 마지막에 .java 가 붙는 경우 리턴
                // + file 인지 검증 추가
                return file.isFile() && name.endsWith(".java");
            }
        }

        // 1. 필터 객체 생성
        JavaFilter javaFilter = new JavaFilter();
        // 2. 필터를 이용해 디렉터리 목록 배열생성
        File path = new File("temp/dummy/");
        String[] names = path.list(javaFilter);
        // 3. 목록 가져오기
        for (String name : names){
            System.out.println(name);
        }
    }
}
