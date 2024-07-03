package com.oop.ex_encapsulation;

/** ~/oop/ex08/a 참조
 *
 *  캡슐화
 *
 *  getter
 *  외부에서 값을 조회할 수 있도록 제공해주는 메서드
 *
 *  (사용법)
 *  private return값 필드;
 *
 *  public return값 get필드(){
 *      return this.필드;
 *  }
 *  
 */

// 계산클래스
class Score {
    String name;
    int kor;
    int eng;
    int math;

    // sum 이나 aver 필드 처럼
    // 기존 필드의 값을 연산해서 나온 결과를 저장하는 경우,
    // 직접 해당 변수의 값을 변경하지 못하도록 막아야 한다.
    // 오직 메서드를 통해서만 변경하도록 해야 한다.
    private int sum=0;
    private float aver=0;

    // 내부에서 값을 처리 후 외부에서 값을 조회할 수 있는 방법/수단(method)를 제공해야 한다.
    // 이를 getter라 하며 get필드명() 형태로 이름짓는다.
    // getter는 public으로 공개된다.
    public int getSum() {
        return sum;
    }

    public float getAver() {
        return aver;
    }

    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
}


public class Main2 {

    public static void main(String[] args) {
        Score s1 = new Score();
        s1.name = "홍길동";
        s1.kor = 100;
        s1.eng = 90;
        s1.math = 80;

        s1.compute();
        // 더이상 private라 접근할 수 없다.
        //s1.aver = 999f; !! 컴파일 에러

        // 출력문
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
            s1.name, s1.kor, s1.eng, s1.math, s1.getSum(), s1.getAver());

    }
}

