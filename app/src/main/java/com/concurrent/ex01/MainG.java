package com.concurrent.ex01;


/**
 *  ~/concurrent/ex01
 *
 *  # JVM의 스레드 계층도
 *
 *  JVM은 실행 시 여러가지의 스레드를 가지고 있다.
 *
 *  system(TG)
 *    ==> Reference Handler(T)
 *    ==> Finalizer(T)
 *    ==> Signal Dispatcher(T)
 *    ==> Attach Listener(T)
 *    ==> Notification Thread(T)
 *    main(TG)
 *     ==> main(T)
 *    InnocuousThreadGroup(TG)
 *     ==> Common-Cleaner(T)
 */

public class MainG {
    public static void main(String[] args) {
        // JVM의 최상위 스레드 그룹인 system의 계층도 출력하기
        // 현재 Thread
        Thread mainThread = Thread.currentThread();
        // 현재 Thread의 Group
        ThreadGroup mainGroup = mainThread.getThreadGroup();
        // 현재 Thread의 Group의 부모 Group
        ThreadGroup systemGroup = mainGroup.getParent();

        printThread(systemGroup, "");

    }

    static void printThread(ThreadGroup tg, String indent) {
        System.out.println(indent + tg.getName() + "(TG)");

        // 스레드 배열을 생성한다.
        Thread[] thread = new Thread[10];
        // 스레드 그룹의 하위 메뉴를 표시할 것 false
        int size = tg.enumerate(thread, false);
        // 스레드를 반복하여 출력한다.
        for (int i=0; i<size; i++){
            System.out.println(indent + " ==> " + thread[i].getName() + "(T)");
        }

        // 스레드 그룹 배열을 생성한다.
        ThreadGroup[] groups = new ThreadGroup[10];
        // 스레드 그룹의 하위 메뉴를 표시할 것 false
        size = tg.enumerate(groups, false);
        // 스레드 그룹을 반복하여 출력한다.
        for (int i=0; i<size; i++){
            printThread(groups[i], indent + " ");
        }
    }
}