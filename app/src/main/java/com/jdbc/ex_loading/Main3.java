package com.jdbc.ex_loading;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  ~/jdbc/ex1
 */

public class Main3 {

    public static void main(String[] args) {
        // JDBC 드라이버 등록3
        // 이미 java.sql.Driver 인터페이스를 구현한 클래스를 로딩한다.
        // 특정 Driver 구현체에 종속되지 않게 만들 수 있다.
        try {
            // Class.forname("FQCN") (패키지명을 초함한 클래스명)
            // 문자열 파라미터로 클래스를 찾아 Method Area(메모리)에 로딩한다.
            Class.forName("com.mysql.jdbc.Driver");

            // 등록 되어있는지 확인
            Driver driver = DriverManager.getDriver("jdbc:mysql://");
            System.out.println(driver);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
