package com.net.basic;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *  ~/net/ex1
 *  클라이언트(client)
 *
 *  (사용법)
 *  new Socket("IP" , Port)
 *
 */

public class Sender {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("클라이언트 실행!");

        // 1) 다른 컴퓨터와 네트워크로 연결한다.
        // 서버와 연결되면 Socket 객체가 생성된다.
        Socket socket = new Socket("127.0.0.1", 8888); // local loopback 127.0.0.1
        System.out.println("서버와 연결된 socket 생성!");

        // 2) 소켓 객체를 통해 읽고 쓸 수 있도록 입출력 스트림을 얻는다.
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("서버와 데이터를 송수신할 스트림 준비. . .");

        // 3) 상대편에서 보낸 문자열을 한 줄 읽는다.
        String str = in.nextLine();
        System.out.printf("서버: %s\n", str);

        // 4) 상대편에게 문자열을 한 줄 보낸다.
        out.println("클라이언트 입니다. 반갑습니다.");
        System.out.println("서버에 데이터 보냈음");



        // 5) 입출력 도구는 사용 후 닫아 메모리를 반환해야 한다.
        out.close();
        in.close();
        scan.close();

        // 6) 네트워크 연결도 닫는다.
        socket.close();

    }

}
