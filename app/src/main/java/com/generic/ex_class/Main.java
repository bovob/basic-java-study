package com.generic.ex_class;

/**
 *  제네릭 적용 전
 *
 *  3개의 BOX 준비
 *  Member, String, Integer
 *  각 BOX 별 Getter, Setter 세팅
 */
class MemberBox{
    Member value;

    public Member getValue() {
        return value;
    }

    public void setValue(Member value) {
        this.value = value;
    }

    /**
     *    public Member(String name, int age) {
     *         this.name = name;
     *         this.age = age;
     *     }
     */
}

class StringBox{
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class IntegerBox{
    Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

public class Main {

    public static void main(String[] args) {

        // Member객체를 저장할 Box 지정
        MemberBox mBox = new MemberBox();
        // mBox에 객체 값 저장
        mBox.setValue(new Member("홍길동", 20));
        // mBox는 Member의 파라미터를 받기 때문에
        // 다른 파라미터 값을 넣으면 컴파일 에러 발생
        //mBox.setValue(new Member("Hello"));
        // mBox 값 꺼내기
        Member m = mBox.getValue();
        System.out.println(m);

        StringBox sBox = new StringBox();
        //sBox.setValue(100); // incompatible types: int cannot be converted to String 컴파일 에러 발생
        sBox.setValue("Hello World!");
        String s = sBox.getValue();
        System.out.println(s);

        IntegerBox iBox = new IntegerBox();
        iBox.setValue(100);
        Integer i = iBox.getValue();
        System.out.println(i);

    }
}
