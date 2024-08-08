package com.concurrent.ex03;

/**
 *  ## Thread 클래스 상속받기
 *
 *  구현하기가 편하다, 다중 상속이 불가능하여 다른 클래스를 상속받을 수 없다.
 *  (사용법)
 *  class MyThread extends Thread {
 *  @Override
 *  public void run(){ - }
 *  }
 *
 *  main {
 *      MyThread t = new MyThread();
 *      t.start();
 *  }
 *
 *  ---------------------------------------------------------------------------------
 *
 *  ## Runnable 인터페이스 상속받기
 *
 *  extend를 통한 다른 클래스 상속이 가능하며, 실제 스레드 실행엔 Thread를 이용해야 한다.
 *
 *  (사용법)
 *  class MyRunnable implements Runnable{
 *  @Override
 *  public void run(){ - }
 *  }
 *
 *  main {
 *      Thread t = new Thread(new MyRunnable());
 *      t.start();
 *  }
 *
 */

public class Main {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

        MyRunnable rt = new MyRunnable();
        Thread rtt = new Thread(rt);
        rtt.start();
    }

    static class MyThread extends Thread{

        @Override
        public void run() {
            for (int i = 0; i<1000; i++){
                System.out.println("===> "+i);
            }
        }
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i<1000; i++){
                System.out.println("~~~~~> "+i);
            }
        }
    }
}
