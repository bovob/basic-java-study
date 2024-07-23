package com.io.ex03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.sound.sampled.Line;

/**
 *  ~/io/ex02~
 *
 *  File 경로 설정시
 *  Linux/Unix : / (루트)
 *  Windows : c:\, d:\ (각 드라이브)
 *
 *  가 아니라면
 *  현재 디렉터리 (프로젝트) 가 된다.
 *  
 *  out = 파일 쓰기
 *  in = 파일 읽기
 *
 *  ###########################################################
 *
 *  1) 데이터 읽기
 *  InputStream (추상클래스)
 *  *-- FileInputStream : 바이트 단위로 읽기 (binary Stream)
 *
 *  Reader (추상클래스)
 *  *-- FileReader : 문자 단위로 읽기 (character Stream)
 *
 *  2) 데이터 쓰기
 *  OutputStream (추상클래스)
 *  *-- FileOutputStream : 바이트 단위로 쓰기 (binary Stream)
 *
 *  Writer (추상클래스)
 *  *-- FileWriter : 문자 단위로 쓰기 (character Stream)
 *
 *  ###########################################################
 *
 *  바이너리 / 텍스트 차이
 *
 *  character set(문자표) 규칙에 따라 작성 : 텍스트
 *                                    작성 하지않음 : 바이너리
 *
 *  편집 에디터가 있다면 편집 후 저장 가능 : 텍스트
 *                전용 프로그램이 필요 : 바이너리
 *
 *  텍스트 예 ) .txt, .csv, .html, .js, .css, .xml, .bat, .c, .py, .php, .docx, .pptx, .xlsx
 *
 *  바이너리 예 ) .pdf, .ppt, .xls, .gif, .mp3, .jpg, .hwp, .mov, .avi, .exe, .lib
 *
 */
public class Main {

    // Line
    public static void Line(){
        final String LINE = "----------------------------------------";
        System.out.println(LINE);
    }

    public static void main(String[] args) throws Exception{


        // 1) 특정 파일 Stream 쓰기
        FileOutputStream out = new FileOutputStream("temp/dummy/hex.txt");
        // A는 41 정상적으로 쓰이지만
        // 가는 00 으로 짤린다.
        out.write('A');     // 0x0041
        out.write('가');    // 0xac00
        // 쓰기 자원 반납
        out.close();
        System.out.println("데이터 출력 완료");



        // 2) 특정 파일 Stream 읽기
        System.out.println("Stream 읽기 시작");
        FileInputStream in = new FileInputStream("temp/dummy/hex.txt");
        // 1바이트 읽어오기
        // read() 호출할 때 마다 이전에 읽은 바이트의 다음 바이트를 읽는다.
        System.out.printf("%02x\n", in.read());     // 41
        System.out.printf("%02x\n", in.read());     // 00
        // 읽기 자원 반납
        in.close();

        Line();

        // 3) 배열을 이용하여 값을 전부 출력하기(쓰기)
        FileOutputStream outStream = new FileOutputStream("temp/dummy/hex2.txt");
        byte[] bytes = {0x7a, 0x6b, 0x5c, 0x4d};
        // 전체를 출력한다.
        outStream.write(bytes);
        // 쓰기 자원 반납
        outStream.close();

        // 4) 반복문을 활용하여 여러 바이트를 읽기
        System.out.println("Stream 반복 시작");
        FileInputStream inStream = new FileInputStream("temp/dummy/hex2.txt");
        int b;
        while ((b = inStream.read()) != -1 ){
            System.out.printf("%02x\n", b);
        }
        // 5번 연계 반납 이후
        // int~ while문 주석처리 이후 5번 확인 가능 [이미 위에서 전부 read 해버림]

        Line();

        // 5) 바이트를 저장할 배열을 준비해보기
        // 이를 "버퍼(buffer)" 라 한다.
        System.out.println("버퍼 시작");
        byte[] buf = new byte[100];
        // 버퍼가 가득 찰 때 까지 읽는다.
        // 버퍼의 크기만큼 반환한다. [현재 : 100]
        int count = inStream.read(buf);

        // 읽기 자원 반납
        inStream.close();

        // 확인하기
        System.out.printf("읽은 바이트 수 : %d\n", count);
        for (int i = 0; i < count ; i++)
            System.out.printf("%02x ", buf[i]);
        System.out.println();

        // 6) 배열의 특정 값을 출력(쓰기) 한다.
        // (사용법) write(byte[], 시작인덱스, 출력갯수)
        FileOutputStream byteOut = new FileOutputStream("temp/dummy/hex3.txt");
        FileInputStream byteIn = new FileInputStream("temp/dummy/hex3.txt");
        byte[] byteOutList = {0x7a, 0x6b, 0x5c, 0x4d, 0x3e, 0x2f, 0x30};
        // 3번 0x5c~0x2f 까지 출력
        byteOut.write(byteOutList, 3, 4);
        // 쓰기 자원 반납
        byteOut.close();

        // 버퍼 설정
        byte[] byteInList = new byte[5];
        // 1번 0x4d 부터 2개 0x3e 까지 저장
        byteIn.read(byteInList, 1, 2);
        byteIn.close();

        // 읽기
        for (int i = 0; i < byteInList.length; i++)
            System.out.printf("%d: %02x\n", i, byteInList[i]);
        System.out.println();
    }

}
