package com.jdbc.ex_loading;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  ~/jdbc/ex1
 *
 *  DBMS(DataBase Management System) 즉 DB에 연결하기 위하여 Java에서는
 *  JDBC(Java DataBase Connectivity) API를 사용하여 연결할 수 있다.
 *
 *  연결 흐름은 다음과 같다.
 *  =>    [ JAVA ]     ->    [JDBC]    ->      [JDBC]      ->       [DB]
 *     [어플리케이션]  <-    [API]     <-    [드라이버]    <-  [데이터베이스]
 *
 *  JDBC는 3가지 표준 인터페이스로 정의 되어있다.
 *  1) java.sql.Connection - 연결
 *  2) java.sql.Statement  - SQL을 담을 내용
 *  3) java.sql.ResultSet  - SQL 요청 응답
 *
 *  JDBC API 사용 흐름은 다음과 같다.
 *  => 1) JDBC 드라이버 로딩
 *     2) Connection 객체 생성
 *     3) Statement 객체 생성
 *     4) Query 실행
 *     5) ResultSet 객체로부터 데이터 조회
 *     6) ResultSet Close
 *     7) Statement Close
 *     8) Connection Close
 *
 */

public class Main {

    public static void main(String[] args) {
        // JDBC 드라이버 등록
        // => java.sql.Driver 규칙에 따라 정의된 클래스를 로딩한다.
        // => Driver 구현체는 DriverManager가 관리한다.
        // 따라서 접속할 DBMS의 Driver 구현체를 생성
        // DriverManager 에게 등록하면 된다.
        // ! 각 DBMS마다 Driver 구현체가 다르다.

        try {
            // Driver 객체 생성
            java.sql.Driver mysqlDriver = new com.mysql.jdbc.Driver();
            // DriverManager 등록
            DriverManager.registerDriver(mysqlDriver);
            System.out.println("JDBC 드라이버 로딩 및 등록 완료!");

            // DriverManager에 등록된 Driver 인스턴스 확인
            System.out.println(mysqlDriver);

            // JDBC URL
            // => jdbc:[DBMS]://서버주소:포트번호/DB명
            //    jdbc:mysql://localhost:3306/studydb
            Driver driver = DriverManager.getDriver("jdbc:mysql://");
            System.out.println(driver);

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
