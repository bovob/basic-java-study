package com.oop.ex_encapsulation;

/** ~/oop/ex08/a 참조
 *
 *  캡슐화
 *
 *  setter
 *  필드에 대한 직접적인 접근을 막아 메서드를 통해 바꾸도록 하는 방법이다.
 *
 *  (사용법)
 *  private return값 필드;
 *
 *  public void set필드(retrun값 필드){
 *      this.필드 = 필드;
 *      처리문(메서드 등);
 *  }
 *  
 */

// 계산클래스
class Score2 {
    String name;
    private int kor;
    private int eng;
    private int math;
    private int sum=0;
    private float aver=0;

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
        this.compute();
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
        this.compute();
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
        this.compute();
    }

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


public class Main3 {

    public static void main(String[] args) {
        Score2 s1 = new Score2();
        s1.name = "홍길동";

        s1.setKor(100);
        s1.setEng(90);
        s1.setMath(80);

        s1.compute();

        // 더 이상 변수에 직접 변경이 불가능하다.
        //s1.kor=200; !! 컴파일 에러


        // 출력문
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
            s1.name, s1.getKor(), s1.getEng(), s1.getMath(), s1.getSum(), s1.getAver());

    }
}

