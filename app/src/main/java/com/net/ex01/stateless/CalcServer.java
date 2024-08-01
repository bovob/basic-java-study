package com.net.ex01.stateless;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  ~/net/ex04
 *
 *  stateless 이란
 *  => 서버에 작업 요청 시 연결 후,
 *     서버로부터 응답을 받으면 연결을 끊는다.
 *     즉, 요청/응답을 한 번만 수행한다.
 *
 *  => 장점
 *     - 서버에 계속 연결된 상태가 아니기 때문에 서버에서 메모리를 적게 쓴다.
 *     - 더 많은 클라이언트의 요청을 처리할 수 있다.
 *
 *   => 단점
 *      - 요청할 때 마다 매번 서버에 연결해야 하기 떄문에 실행시간이 많이 걸린다.
 *      - 서버와 연결할 때, 사용자 인증/권한 확인 같은 작업을 수행하는경우 더더욱 오래 걸린다.
 *
 *   => 작업시간
 *       연결하는데 걸리는 시간 + 데이터 전송 시간 + 작업 처리 시간 + 데이터 수신 시간
 *
 *   => 사용 예
 *      HTTP, 메신저, 메일전송
 */
public class CalcServer {

    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중 . . .");

        ServerSocket ss = new ServerSocket(8888);

        while (true) {
            Socket socket = ss.accept();
            System.out.println("클라이언트 요청 처리!");

            try{
                processRequest(socket);
            } catch (Exception e){
                System.out.println("클라이언트 요청 처리 중 오류 발생");
                System.out.println("다음 클라이언트 요청을 처리합니다.");
            }
        }
    }

    static void processRequest(Socket socket) throws Exception{
      try (Socket socket2 = socket; DataInputStream in = new DataInputStream(socket.getInputStream()); PrintStream out = new PrintStream(socket.getOutputStream())){
          int a = in.readInt();
          String op = in.readUTF();
          int b = in.readInt();
          int result = 0;

          switch (op) {
              case "+":
                  result = a + b;
                  break;
              case "-":
                  result = a - b;
                  break;
              case "*":
                  result = a + b;
                  break;
              case "/":
                  result = a + b;
                  break;
              default:
                  System.out.println("해당 연산은 지원하지 않습니다.");
                  return;
          }
          out.printf("%d %s %d = %d\n", a, op, b, result);
      }
    }
}
