package com.oop.ex_class;

/** ~/oop/ex03 참조
 *
 */

public class Main2 {

    public static void main(String[] args){

        // 저장하고 싶은 데이터 개수 만큼 인스턴스를 생성
        Score s1 = new Score(); // 1명씩 s1 ~ s3 총 3명
        Score s2 = new Score();

        // 각 인스턴스에 성적 데이터 저장
        s1.name = "홍길동";
        s1.kor = 100;
        s1.eng = 90;
        s1.math = 80;
        s1.sum = s1.kor + s1.eng + s1.math;
        s1.average = s1.sum / 3f;

        s2.name = "임꺽정";
        s2.kor = 100;
        s2.eng = 100;
        s2.math = 100;
        s2.sum = s2.kor + s2.eng + s2.math;
        s2.average = s2.sum / 3f;

        System.out.print("이름 : %s");
    }

    // 성적 데이터를 설계할 클래스
    static class Score{
        // 여러 명의 성적 데이터를 저장해야 함으로 인스턴스 변수로 설계
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float average;
    }

    static class A{

    }
}
