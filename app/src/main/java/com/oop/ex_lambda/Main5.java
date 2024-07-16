package com.oop.ex_lambda;

interface Name {
    String compute(String LastName);
    }

class My implements Name {
    String firstName;

    public My(String firstName){
        this.firstName = firstName;
    }

    @Override
    public String compute(String lastName) {
        return firstName + lastName;
    }
}

public class Main5 {

    static Name create1(String firstName){
        return new My(firstName);
    }

    public static void main(String[] args) {

        Name n = create1("홍");
        System.out.println(n.compute("길동"));
    }

}
