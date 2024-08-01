package com.net.ex01.stateful2;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  다중 클라이언트의 요청 처리하기
 *  
 *  클라이언트와 통신하는 부분을 별도의 스레드(실행흐름)로 분리하여 실행한다.
 * 
 */
public class CalServer {
    
    public static void main(String[] args) throws Exception{
        System.out.println("서버 실행 중. . .");

        // 서버소켓 선언 ss
        // 포트 8888
        ServerSocket ss = new ServerSocket(8888);

        while (true) {
            System.out.println("클라이언트 연결을 기다림");
            // 클라이언트 연결을 기다림
            Socket socket = ss.accept();
            InetSocketAddress remoteAddr = (InetSocketAddress) socket.getRemoteSocketAddress();
            System.out.printf("클라이언트(%s:%d)가 연결되었음!\n", remoteAddr.getAddress(), remoteAddr.getPort());
            // 여기까지는 기존 클라이언트와의 연결을 유지하여
            // 요청을 처리하여 다른 클라이언트의 요청을
            // 처리할 수 없다.
            //---------------------------------------------------------------------------------------------------------
            // 아래 Thread를 상속받은 RequestHander에 Socket을 전달하고
            // 오버라이딩 한 run()을 실행시키는 start()를 수행하게 한다.
            // 그럼 main()은 바로 start() 호출 뒤 바로 return 한다.
            RequestHander requestHander = new RequestHander(socket);
            requestHander.start();
        }

    }

    // 스레드를 상속받는 내부 요청핸들러 클래스
    static class RequestHander extends Thread{

        // 소켓 선언
        Socket socket;

        // 소켓을 받는 생성자 생성
        public RequestHander(Socket socket) {
            this.socket = socket;
        }

        // main() 메서드 호출과 분리하여 별도로 실행할 코드가 있다면
        // run() 메서드에 둔다.
        // 이것은 main()이 아닌 run()에서 따로 실행되게 된다.
        // 이때, 호출은 run()이 아닌 start()로 호출한다.
        @Override
        public void run() {
            try(Socket socket2 = socket;
                DataInputStream in = new DataInputStream(socket.getInputStream());
                PrintStream out = new PrintStream(socket.getOutputStream())){
                // 결과값을 저장할 변수
                int result = 0;

                loop: while(true){
                    String op = in.readUTF();
                    int a = in.readInt();

                    switch (op){
                        case "+":
                            result += a;
                            break;
                        case "-":
                            result += a;
                            break;
                        case "*":
                            result += a;
                            break;
                        case "/":
                            result += a;
                            break;
                        case "quit":
                            break loop;
                        default:
                            out.println("해당 연산은 지원되지 않습니다.");
                            continue;
                    }

                    out.printf("계산결과 : %d\n", result);
                }
                // 해당 결과 반환시 클라이언트 종료
                out.println("quit");

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("클라이언트 연결 종료!");
            }
        }
    }
    
     
}
