package com.net.ex01.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *  다중 클라이언트의 요청 처리하기
 *
 *  클라이언트와 통신하는 부분을 별도의 스레드(실행흐름)로 분리하여 실행한다.
 *
 */
public class CalServer {

    // 번호(아이디값)과 결과값을 hashmap에 담는다.
    static Map<Long, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행중 . . .");
        // 서버 포트 설정
        ServerSocket ss = new ServerSocket(8888);

        while (true){
            System.out.println("클라이언트 연결 기다림!");
            // 클라이언트 소켓연결 대기
            Socket socket = ss.accept();
            // socket의 주소를 받아옴
            InetSocketAddress remoteAddr = (InetSocketAddress) socket.getRemoteSocketAddress();

            System.out.printf("클라이언트(%s:%d)가 연결되었음!", remoteAddr.getAddress(), remoteAddr.getPort());

            RequestHandler requestHandler = new RequestHandler(socket);

            requestHandler.start();
            System.out.printf("%s 클라이언트 요청을 스레드에게 맡겼습니다.\n", remoteAddr.getAddress());

        }
    }

    // 스레드를 상속받은 핸들러 내부클래스 생성
    static class RequestHandler extends Thread {

        Socket socket;

        // 소켓을 받아올 생성자 생성
        public RequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket socket2 = socket; DataOutputStream out = new DataOutputStream(
                socket.getOutputStream()); DataInputStream in = new DataInputStream(
                socket.getInputStream())) {
                // 클라이언트 ID 값을 받는다.
                long clientId = in.readLong();
                // 연산을 위한 연산자와 값을 받는다.
                String op = in.readUTF();
                int value = in.readInt();

                // 기존 ID값을 가진 클라이언트의 값을 꺼낸다.
                Integer obj = resultMap.get(clientId);
                int result = 0;

                if (obj != null) {
                    // 기존 고객 map의 값을 result에 넣는다.
                    System.out.printf("%d 기존고객 요청처리\n", clientId);
                    result = obj;
                } else {
                    // 신규 고객은 현재시간을 millisec 으로 저장해둔다.
                    clientId = System.currentTimeMillis();
                    System.out.printf("%d 신규고객 요청처리\n", clientId);
                }
                // 연산처리
                switch (op) {
                    case "+":
                        result += value;
                        break;
                    case "-":
                        result -= value;
                        break;
                    case "*":
                        result *= value;
                        break;
                    case "/":
                        result /= value;
                        break;
                }
                // 클라이언트로 응답할 때 항상 클라이언트 아이디와 결과를 출력한다.
                // => 클라이언트 아이디 출력
                out.writeLong(clientId);

                // => 계산 결과 출력
                out.writeInt(result);
                out.flush();

                // 계산 결과를 다시 resultMap에 보관한다.
                resultMap.put(clientId, result);

            } catch (Exception e) {
                System.out.println("클라이언트 요청 처리 중 오류 발생!");
            } finally {
                System.out.println("클라이언트 연결 종료!");
            }
        }
    }
}