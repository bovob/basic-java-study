package com.io.ex01;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *  파일 생성 전 절대경로를 알아낼 때
 *
 *  getParentFile(); 을 통해 파일의 부모 디렉토리 존재 여부를 알 수 있다.
 *
 *  getCanonicalPath(); 를 통해 파일시스템의 디렉토리 절대 경로 값을 알 수 있다.
 *
 *  FileName.list(); 경로에 들어있는 파일/디렉토리 정보를 알아낼 수 있다.
 *
 *  File[] files = [File 변수].listFiles(); 경로에 있는 파일/디렉토리 리스트를 담는다.
 *
 */

public class Main5 {

    public static void main(String[] args) throws IOException {
        File checkDir = new File("temp2/b/test.txt");

        // 파일을 생성하기 전에 존재하지 않는 폴더를 생성하고 싶다면,
        //    String path = file.getParent(); // => temp/b
        //    File dir = new File(path);
        File dir = checkDir.getParentFile(); // =위의 코드와 같다.
        System.out.println(dir);
        System.out.println(dir.getCanonicalPath());

        File dirList = new File(".");

        String[] names = dirList.list();
        System.out.println("--- Current DIR LIST ---");
        for (String name : names){
            System.out.println(name);
        }

        System.out.println("--- DIR Check ---");

        File[] files = dirList.listFiles();
        for (File file : files) {
            System.out.printf("%s   %s %12d %s\n",
                file.isDirectory() ? "d" : "-",
                new Date(file.lastModified()),
                file.length(),
                file.getName());
        }



    }

}
