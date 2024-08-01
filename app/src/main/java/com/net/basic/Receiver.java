package com.net.basic;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *  ~/net/ex1
 *  서버(Server)
 *
 *  (사용법)
 *  new ServerSocket(포트번호)
 *
 */

public class Receiver {

    public static void main(String[] args) throws Exception {
        Scanner scan =new Scanner(System.in);
        System.out.println("서버 실행");

        // 1) 다른 컴퓨터의 연결 요청을 기다린다.
        // 예외처리를 해야 한다.
        ServerSocket serverSocket = new ServerSocket(8888);

        // 2) 연결을 기다리고 있는 클라이언트가 있다면 연결승인
        // accept()를 호출하면 대기열에서 순서대로 꺼내어 클라이언트와의 연결된 소켓을 만든다.
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트와 연결된 Socket 생성!");

        // 3) 소켓 객체를 통해 읽고 쓸 수 있도록 입출력 스트림을 받는다.
        // 연결된 클라이언트로 데이터를 보내고 받으려면 입출력 스트림을 꺼내야 한다.
        // 소켓이 리턴해준 입출력 스트림에 적절한 데코레이터를 붙여서 사용한다.
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("데이터 송수신 입출력 스트림 준비. . .");

        // 4) 클라이언트로 문자열을 한 줄 보낸다.
        // 클라이언트가 데이터를 받을 때 까지 기다리지 않는다.
        // NIC의 메모리에 데이터를 전달한 후 즉시 리턴한다.
        out.println("서버입니다. 반갑습니다.");
        System.out.println("클라이언트로 데이터 보내기 완료");

        // 5) 클라이언트가 보낸 문자열을 한 줄 읽는다.
        // 클라이언트가 한 줄의 데이터를 보낼 때 까지 리턴하지 않는다.
        // => 이를 블로킹 메서드라 한다.
        String str = in.nextLine();
        System.out.printf("클라이언트: %s\n", str);

        // 6) 입출력 도구는 사용 후 닫아 메모리를 반환해야 한다.
        out.close();
        in.close();
        scan.close();

        // 7) 네트워크 연결도 닫는다.
        socket.close();
        serverSocket.close();


    }

}
