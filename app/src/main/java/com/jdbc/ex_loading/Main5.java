package com.jdbc.ex_loading;

import java.io.FileReader;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *  ~/jdbc/ex1
 *
 *  System Properties 활용하기
 *
 *  1)
 *  System Properties 는 JVM에 설정된 "Key=Value"다.
 *  시스템 프로퍼티를 꺼내는것은 다음과 같다.
 *
 *  => System.getProperty("jdbc.drivers")
 *
 *  반대로 시스템 프로퍼티를 세팅하는 것은 다음과 같다.
 *
 *  => System.setProperty("[Name]", "[Class 위치]")
 *
 *
 *  2) JVM을 실행할 때 JVM에 옵션을 지정한다.
 *
 *  => java -Djdbc.drivers=[클래스명]
 *
 *
 */

public class Main5 {

    public static void main(String[] args) {
        try {
            System.out.printf("java.home=%s\n", System.getProperty("java.home"));

            Driver driver = DriverManager.getDriver("jdbc:mysql://");
            System.out.println(driver);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
