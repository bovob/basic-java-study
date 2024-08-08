package com.concurrent.ex03;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


/**
 * Thread Pool
 *
 * 스레드 풀은 JAVA의 스레드를 효율적으로 관리하는 방법이다.
 * 미리 정의된 수의 스레드를 생성해 두고 필요할 때 재사용한다.
 * 이는 새로운 스레드를 생성하는 오버헤드를 줄이고 더욱 자원을 효율적으로 쓰게 해 준다.
 *
 * ExecutorsService를 이용한다.
 *
 */

public class Main2 {

    public static void main(String[] args) {
        // 스레드 풀에 2개의 스레드를 생성해둔다.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 스레드 풀에서 스레드를 실행한다.
        for (int i = 0; i < 5; i++) {
            // 5개의 Runnable Thread를 생성
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }

        // 새로운 작업은 받지 않도록 한다.
        executor.shutdown();
        // 작업이 끝날 때 까지 기다린다.
        while (!executor.isTerminated()) {
        }

        System.out.println("작업 끝!");
    }
}

class WorkerThread implements Runnable {
    private final String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000); // 작업 처리 시간 시뮬레이션
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}