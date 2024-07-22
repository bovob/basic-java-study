package com.generic.ex_class;

/**
 *  제네릭 적용
 *
 *  => 클래스 전체에서 사용할 "타입 파라미터"를 선언하여 사용한다.
 *  => < 파라미터_타입 > 을 받음으로써 특정 타입만을 다루는 전용 객체를 만들 수 있다.
 *  => <> 를 비워둔다면 이는 <Object> 와 같이 사용할 수 있다.
 */

public class Main3 {

    public static void main(String[] args) {

        // Member를 받아 사용한다.
        Box<Member> b1 = new Box<Member>();
        b1.setValue(new Member("홍길동", 20));
        Member m1 = b1.getValue();
        System.out.println(m1);

        // String을 받아 사용한다.
        Box<String> b2 = new Box<String>();
        b2.setValue("Hello World!");
        String m2 = b2.getValue();
        System.out.println(m2);

        // <> 타입지정을 하지않는다면 <Object> 와 같다.
        // 매개화 된 클래스의 원시 사용이라는 경고가 발생한다.
        Box b3 = new Box();
        b3.setValue("아무거나");
        b3.setValue(1000);
        b3.setValue(new Member("유관순", 25));

    }

    // Type Parameter <T>를 받는 Box Class 생성
    static class Box<T>{
        T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
