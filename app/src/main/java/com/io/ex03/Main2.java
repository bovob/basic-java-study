package com.io.ex03;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *  ~/io/ex02~
 *
 */
public class Main2 {

    // Line
    public static void Line(){
        final String LINE = "----------------------------------------";
        System.out.println(LINE);
    }

    public static void main(String[] args) throws Exception{
        Line();

        // 문자 준비
        String str = "AB가각핳";
        // 현재 인코딩 설정 확인
        System.out.println("현재 incoding : "+ System.getProperty("file.encoding"));
        System.out.println("저장 문자열 : "+str);

        // CharSet : MS949 , UTF-8 , UTF-16BE , UTF-16LE
        // 윈도우 MS949 설정
        byte[] bytes = str.getBytes("MS949");
        Line();
        System.out.println("바이트 출력");
        // 문자 바이트 출력
        for (byte b : bytes){
            System.out.printf("%x ", b);
        }System.out.println();
        
        FileOutputStream out = new FileOutputStream("temp/ms949.xt");
        out.write(bytes);
        out.close();


    }

}
