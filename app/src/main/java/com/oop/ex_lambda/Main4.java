package com.oop.ex_lambda;
/**
 *  팩토리 메서드에서의 사용
 *
 *  팩토리 메서드는 객체 생성(new xxx())를 캡슐화 하여
 *  클라이언트 코드가 직접 생성자 호출을 하지 않고
 *  객체를 생성할 수 있게 해주는 디자인 패턴이다.
 *
 *  객체의 생성 로직을 숨기고
 *  유연한 객체 생성 및 코드 재사용성을 높일 수 있다.
 *
 */

// 인터페이스 생성
interface InterestCalculator{
    double compute(int money);
}

public class Main4 {

    // 1) 일반
    static InterestCalculator create1(double rate) {
        return new My(rate);
    }

    // 2) 일반 + 로컬 클래스
    // 생성자가 자동적으로 생기며
    // 전달되는 파라미터를 그대로 값을 쓸 수 있다.
    static InterestCalculator create2(double rate){
        class My implements InterestCalculator{

            @Override
            public double compute(int money) {
                return money + (money * rate);
            }
        }
        return new My();
    }

    // 3) 익명 클래스
    // 내부에서 생성자를 생성한 후 return 해준다.
    // ; 를 빠뜨리면 안된다.
    static InterestCalculator create3(double rate){
        InterestCalculator c = new InterestCalculator() {
            @Override
            public double compute(int money) {
                return money + (money * rate);
            }
        };
        return c;
    }

    // 4) 익명 클래스 직접대입
    // 바로 return 을 통하여 생성자를 리턴한다.
    // ; 를 빠뜨리면 안된다.
    static InterestCalculator create4(double rate){
        return  new InterestCalculator() {
            @Override
            public double compute(int money) {
                return money + (money * rate);
            }
        };
    }

    // 5) 람다
    static InterestCalculator create5(double rate){
        InterestCalculator c = money -> money + (money + rate);
        return c;
    }

    // 6) 람다 직접대입
    static InterestCalculator create6(double rate){
        return money -> money + (money + rate);
    }

    public static void main(String[] args) {
        InterestCalculator c1 = create1(0.035);
        System.out.println(c1);
        System.out.printf("%.2f",c1.compute(1000_0000));

        System.out.println(create2(0.035).compute(1000_0000));
        System.out.println(create3(0.035).compute(1000_0000));
        System.out.println(create4(0.035).compute(1000_0000));
        System.out.println(create5(0.035).compute(1000_0000));
        System.out.println(create6(0.035).compute(1000_0000));
    }

    static class My implements InterestCalculator {
        final double rate;

        public My(double rate) {
            this.rate = rate;
        }
        @Override
        public double compute(int money) {
            return money + (money * rate);
        }
    }

}
