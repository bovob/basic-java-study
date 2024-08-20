package com.jdbc.ex_loading;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  ~/jdbc/ex1
 */

public class Main2 {

    public static void main(String[] args) {
        // JDBC 드라이버 등록2
        // DriverManager에 굳이 등록 할 필요가 없다
        // Driver 구현체가 로딩 될 때 static 블록에서 자동으로
        // 인스턴스를 만들어 등록한다.


        try {
            // Driver 인스턴스 생성
            new com.mysql.jdbc.Driver();

            // 등록 되어있는지 확인
            Driver driver = DriverManager.getDriver("jdbc:mysql://");
            System.out.println(driver);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
