package com.net.ex01.stateful;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  ~/net/ex04
 *
 *  stateful 이란
 *  => 서버와 연결한 후,
 *     클라이언트에서 연결을 끊을 때 까지(혹은 서버에서 연결을 끊을 때 까지)
 *     계속해서 연결을 유지하며 클라이언트의 요청을 처리한다.
 *
 *   => 장점
 *      - 한 번 연결하면 연결을 끊을 때 까지 유지한다.
 *      - 클라이언트가 작업을 요청하지 않더라도 계속 유지하기 때문에
 *        영속성이 필요한 작업을 처리하는데 유리하다.
 *      - 작업 요청에 대한 응답이 빠르다.
 *
 *   => 단점
 *      - 클라이언트가 연결을 끊지 않고 대기하더라도 연결을 유지 하기 때문에
 *        서버 메모리를 많이 차지한다.
 *      - 이전 클라이언트가 연결을 끊지 않는다면 다음 클라이언트와
 *        서버가 연결되지 못하는 문제가 있다.
 *      - 따라서 동시에 여러 클라이언트의 처리가 힘들다
 *
 *    => 작업시간
 *       데이터 전송 시간 + 작업 처리 시간 + 데이터 수신 시간
 *       -> 즉 작업 요청할 때마다 연결할 필요가 없어
 *          연결 하는데 시간이 걸리지 않는다.
 *
 *    => 사용 예
 *       게임서버, 화상통신, 채팅서버, 텔넷, FTP
 */

public class CalcServer {

    public static void main(String[] args) throws Exception {
        System.out.println("서버가 실행 중 . . .");

        // IOException 에러 처리가 필요하다.
        // 8888 포트데 대기하는 서버 소켓을 생성한다.
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            // accept() 메소드가 호출되면 프로그램은
            // 실행을 멈추고 8888번 포트에 클라이언트가 연결될 때 까지 대기한다.
            // 클라이언트가 연결된다면 socket을 반환한다.
            // try에 socket을 선언하면 socket.close를 자동으로 해준다.
            try(Socket socket = serverSocket.accept()){
                processRequest(socket);
            } catch (Exception e){
                System.out.println("클라이언트 요청처리 중 오류 발생");
                System.out.println("다음 클라이언트의 요청을 처리합니다.");
            }
        }
        // serversocket.close();


    }

    // 요청을 처리하는 메소드
    static void processRequest(Socket socket) throws Exception {
        // 소켓정보와 Input, Output Stream을 받아온다.
        // 마찬가지로 try에서 자동적으로 close를 시켜준다.
        try (Socket s = socket;
            DataInputStream in = new DataInputStream(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream())){

            // loop 태그
            loop: while(true){
                // a,b (연산값) op (연산자) result (결과값)을 선언한다.
                int a = in.readInt();
                String op = in.readUTF();
                int b = in.readInt();
                int result = 0;

                switch (op){
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "/":
                        result = a + b;
                        break;
                    case "*":
                        result = a + b;
                        break;
                    case "%":
                        result = a % b;
                        break;
                    case "quit":
                        break loop;
                    default:
                        out.println("해당 연산은 지원하지 않습니다.");
                        continue;
                }
                out.printf("연산결과 %d %s %d = %d \n", a, op, b, result);
            }

            out.println("Goodbye!");
        }

    }

}
