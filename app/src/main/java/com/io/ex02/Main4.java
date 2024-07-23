package com.io.ex02;

import java.io.File;
import java.io.IOException;

/**
 *   io/ex01/
 *
 *  CanonicalPath 전체 디렉터리 검색
 */

public class Main4 {

    // Line
    public static void Line(){
        final String LINE = "----------------------------------------";
        System.out.println(LINE);
    }

    public static void main(String[] args) throws Exception {

        // 0. 더미 파일 생성
        String[] fileExtention = new String[]{"txt", "jpg", "java", "c", "py", "yml"};
        File dummyPath = new File("temp/list/");
        File dummyPath2 = new File("temp/list/dummyDir");
        String dummyFileName = "test";

        // 디렉터리 생성 mkdirs(하위 디렉터리까지)
        if(!dummyPath.exists()){
            dummyPath.mkdirs();
            System.out.println("디렉터리 생성");
        }
        if(!dummyPath2.exists()){
            dummyPath2.mkdirs();
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

        // 현재 Path
        Line();
        File dir = new File("temp/list/");
        System.out.println(dir.getCanonicalPath());

        // Path 이하 파일들
        Line();
        printList(dir, 1);
    }

    static void printList(File dir, int level){
        // 파일 목록들 리스트에 넣어둔다.
        File[] files = dir.listFiles();

        // 파일 배열에서 이름을 꺼내 출력한다.
        String indent = getIndent(level);

        // 배열에서 이름을 꺼내 출력한다.
        for (File file : files){
            System.out.print(indent);

            // 디렉터리 확인 & 숨김아닌 것 확인
            if(file.isDirectory() && !file.isHidden()){
                System.out.printf("%s\n", file.getName());
                printList(file, level+1);
            } else if (file.isFile()) {
                System.out.print("\\--");
                System.out.printf("%s\n", file.getName());
            }
        }
    }

    static String getIndent(int level){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < level ; i++){
            stringBuilder.append(" ");
        }
        return  stringBuilder.toString();
    }
}
