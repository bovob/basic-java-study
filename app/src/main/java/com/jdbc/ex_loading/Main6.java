package com.jdbc.ex_loading;

import java.sql.Driver;
import java.sql.DriverManager;

/**
 *  ~/jdbc/ex1
 *
 *  java.sql.Driver 클래스의 서비스 제공자를 찾아 로딩
 *  [외부 의존 라이브러리]
 *  mysql.jar
 *  ㄴ META-INF
 *      ㄴ services
 *          ㄴ java.sql.Driver 파일에 이미 등록이 되어있다면
 *                             따로 Driver 구현체를 명시하여 등록하지 않아도 된다.
 *
 */

public class Main6 {

    public static void main(String[] args) {
        try {
            Driver driver = DriverManager.getDriver("jdbc:mysql://");
            System.out.println(driver);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
