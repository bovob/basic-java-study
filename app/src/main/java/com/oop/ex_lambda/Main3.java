package com.oop.ex_lambda;

interface Player{
    void play();
}

public class Main3 {

    public static void main(String[] args) {
    //    1)일반
        class Myplay implements Player{
            @Override
            public void play() {
                System.out.println("1");
            }
        }
        test(new Myplay());

    //    2)익명
        Player p2 = new Player(){
            @Override
            public void play() {
                System.out.println("2");
            }
        };
        test(p2);

    //    3)익명 직접
        test(new Player(){
            @Override
            public void play() {
                System.out.println("3");
            }
        });

    //    4)람다
        Player p4 = () -> {System.out.println("4");};
        test(p4);

    //    5)람다 중괄호
        Player p5 = () -> System.out.println("5");
        test(p5);

    //    6)람다 직접
        test(() -> System.out.println("6"));
    }

    static void test(Player player){
        player.play();
    }

}
