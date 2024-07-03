package com.oop.ex_encapsulation;

/** ~/oop/ex08/a 참조

      캡슐화?
      => 인스턴스의 변수에 추상화 목적에 맞는 유효한 값만 넣을 수 있도록
         외부 접근을 제한하는 문법이다.
      => 제한 범위
         private   : 클래스 내부에서만 접근 가능
         (default) : 클래스 내부 + 같은 패키지
         protected : 클래스 내부 + 같은 패키지 + 자식클래스
         public    : 모두 접근 가능!

 */


public class Main {

    public static void main(String[] args) {
        Score s1 = new Score();
        s1.name = "홍길동";
        s1.kor = 100;
        s1.eng = 90;
        s1.math = 80;

        // 값.연산자()
        // 변수 값에 담긴 인스턴스 메서드를 다루는 메서드를
        // 연산자(Operator)라 부른다.
        s1.compute();

        // 출력문
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
            s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.aver);

        Score s2 = new Score();
        s2.name = "유관순";
        s2.kor = 100;
        s2.eng = 100;
        s2.math = 100;

        // 연산 이후 계산을 임의적 변경
        s2.compute();
        s2.aver=0f;
        s2.kor = 0;
        s2.eng = 0;
        s2.math = 0;


        // 출력문
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
            s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.aver);

        // sum 이나 aver 필드 처럼
        // 기존 필드의 값을 연산해서 나온 결과를 저장하는 경우,
        // 직접 해당 변수의 값을 변경하지 못하도록 막아야 한다.
        // 오직 메서드를 통해서만 변경하도록 해야 한다.


    }

    // 계산클래스
    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;

        void compute() {
            this.sum = this.kor + this.eng + this.math;
            this.aver = this.sum / 3f;
        }
    }
}
