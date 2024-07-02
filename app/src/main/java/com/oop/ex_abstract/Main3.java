package com.oop.ex_abstract;

/** ~/oop/ex07/a 참조
 *
 *  추상클래스 & 추상메서드 응용
 */

abstract class Letter {

    // 수퍼 클래스는 서브 클래스에게 구현된 멤버를 상속해준다.
    String content;

    public void setContent(String content) {
        this.content = content;
    }

    // 슈퍼 클래스에서 기능이 어떻게 동작하는지 정의한다.
    // 템플릿 역할을 하는 메서드를 수퍼 클래스에 둔다.
    // 동작의 흐름이 변경되면 안되기 때문에 final 로 선언하여 오버라이딩을 막는다.

    // GoF 의 Template Method 활용
    public final void print() {
        this.printHeader();
        System.out.println(this.content);
        System.out.println();
        System.out.printf("          [ From %s ]\n", this.getSign());
        System.out.println();
        this.printFooter();
    }

    // 세부사항은 서브 클래스에 구현을 맡긴다.
    public abstract void printHeader();
    public abstract void printFooter();
    public abstract String getSign();
}

class LoveLetter extends Letter{
    @Override
    public void printHeader(){
        System.out.println("사랑하는 그대에게 ...");
    }
    @Override
    public void printFooter(){
        System.out.println(" ~~~~ ");
    }
    @Override
    public String getSign(){
        return  " 당신의 팔로워 ...";
    }

}

class ReportLetter extends Letter{
    @Override
    public void printHeader(){
        System.out.println("존경하는 교수님께 !");
    }
    @Override
    public void printFooter(){
        System.out.println(" ~~~ A+ 주세요!!! ~~~ ");
    }
    @Override
    public String getSign(){
        return  " 학생 : 홍길동 ";
    }
}


public class Main3 {

    public static void main(String[] args) {

        Letter letter = new LoveLetter();
        letter.setContent("눈이 녹으면 무엇이 될까요?\n"
            + "봄이 온다 합니다.\n"
            + "따스한 봄이 기다려지네요.");
        letter.print();

        Letter letter2 = new ReportLetter();
        letter2.setContent("강의가 끝났다!");
        letter2.print();

    }
}
