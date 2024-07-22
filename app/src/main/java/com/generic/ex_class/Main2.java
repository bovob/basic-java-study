package com.generic.ex_class;

/**
 *  제네릭 적용 전
 *
 *  3개의 BOX 준비
 *  Member, String, Integer
 *  각 BOX 별 Getter, Setter 세팅
 *
 *  해당 클래스들을 다형적 변수(Object)를 이용하여
 *  같은 Box로 담을 수 있다.
 *
 *  장점
 *  => 이전 방식에 비해서 객체 타입 별 Box를 구분할 필요가 없어 코드가 간결하다.
 *  => 여러가지 다양한 객체를 담을 수 있다.
 *
 *  단점
 *  => 특정 타입의 객체로 제한할 수 없다.
 *  => 값을 꺼낼 때 원래의 타입으로 바꾸기 위해 형변환을 해야한다.
 *
 */
class ObjectBox{
    Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

public class Main2 {

    public static void main(String[] args) {

        // Member, String, Integer를 담을 Box 준비
        ObjectBox box1 = new ObjectBox();
        ObjectBox box2 = new ObjectBox();
        ObjectBox box3 = new ObjectBox();

        // Object에 값 넣기
        // Object는 모든 자바의 객체의 부모이다.
        // => 모든 값을 넣을 수 있다.
        box1.setValue(new Member("홍길동",20));
        box2.setValue("Hello World!");
        box3.setValue(100); // auto-boxing에 의해 box.setValue(Integer.valueOf(100))이 된다.

        // Object 객체 값 꺼내기
        // => 값을 꺼낼 때 마다 형변환이 필요하다.
        Member m1 = (Member) box1.getValue();
        System.out.println(m1);

        String s1 = (String) box2.getValue();
        System.out.println(s1);

        Integer i1 = (Integer) box3.getValue();
        System.out.println(i1);

    }
}
