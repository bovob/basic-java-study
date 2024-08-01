package com.net.ex01.stateless;

import java.io.DataOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
public class CalcClient {

    public static void main(String[] args) {
        // keyboard 입력 scanner 선언
        Scanner keyscan = new Scanner(System.in);

        while (true){
            // 값 a,b 연산자 op 선언
            System.out.println("a : ");
            int a = Integer.parseInt(keyscan.nextLine());

            System.out.println("연산자 : ");
            String op = keyscan.nextLine();

            System.out.println("b : ");
            int b = Integer.parseInt(keyscan.nextLine());

            // 소켓 및 in/out stream 선언
            try (Socket socket = new Socket("localhost", 8888);
            Scanner in = new Scanner(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                // 서버로 전달
                out.writeInt(a);
                out.writeUTF(op);
                out.writeInt(b);

                String str = in.nextLine();
                System.out.println(str);

            } catch (Exception e){
                System.out.println("통신오류발생!");
            }

            System.out.print("계속 하시겠습니까 ? (y/n)");
            if (keyscan.nextLine().equalsIgnoreCase("n")){
                break;
            }
         }
        keyscan.close();
    }

}
