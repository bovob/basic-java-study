package com.net.ex01.stateful;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

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

public class CalcClient {

    public static void main(String[] args) throws Exception {
        // 입력을 위한 scanner를 선언한다.
        Scanner scan = new Scanner(System.in);

        // 소켓을 준비한다.
        // "( " SERVER_IP " , PORT )
        Socket socket = new Socket("localhost", 8888);
        // 데이터 입출력을 위한
        // In, Out Stream을 선언한다.
        Scanner in = new Scanner(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while (true) {
            // scan 순서 int a, string op, int b
            System.out.println("A값 입력 : ");
            out.writeInt(Integer.parseInt(scan.nextLine()));

            System.out.println("연산자 입력(quit 종료) : ");
            out.writeUTF(scan.nextLine());

            System.out.println("B값 입력 : ");
            out.writeInt(Integer.parseInt(scan.nextLine()));

            // flush 를 통하여 현재 스트림의 값을 전부 꺼낸다.
            out.flush();

            // 서버의 출력값을 받아온다.
            String str1 = in.nextLine();
            System.out.println(str1);

            // 서버의 출력값이 goodbye 라면 반복을 끝낸다.
            if (str1.equals("Goodbye!"))
                break;

        }
        in.close();
        out.close();
        socket.close();
        scan.close();
    }
}
