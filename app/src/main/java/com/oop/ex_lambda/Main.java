package com.oop.ex_lambda;
/**
 *  ~/oop/ex12 참조
 *
 *  Java 8 부터 추가된 람다 표현식은
 *  익명 함수(Anonymous Function)을 생성하기 위하여 간결하게 표현한 문법이며
 *
 *  코드의 가동성과 간결성을 높일 수 있다.
 *
 *  (사용법)
 *  () -> { };
 *
 */


public class Main {

    public static void main(String[] args) {
        // 1) 일반 클래스
        class Myplayer implements Player{
            @Override
            public void Play() {
                System.out.println("일반클래스");
            }
        }

        Player p1 = new Myplayer();
        p1.Play();

        // 2) 익명 클래스
        Player p2 = new Myplayer(){
            @Override
            public void Play(){
                System.out.println("익명 클래스1");
            }
        };

        p2.Play();

        // 3) 익명 클래스
        new Myplayer(){
            @Override
            public void Play() {
                System.out.println("익명 클래스2");
            }
        }.Play();

        // 4) 람다
        Player p4 = () -> { System.out.println("람다 클래스");};
        p4.Play();

        // 5) 람다2
        Player p5 = () -> System.out.println("람다2 클래스");
        p5.Play();
    }

    interface Player{
        void Play();
    }
}
