package com.jdbc.api;

/**
 * build 에 JDBC 의존성 check
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    // JDBC 연결을 위한 URL, ID, PW
    private static final String URL = "jdbc:mysql://localhost:3306/basicdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";

    // DB Connection
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("MYSQL 연결 성공");
            return con;
        }
        catch (Exception e) {
            System.out.println("연결실패 : " + e.getMessage());
            return null;
        }

    }

    public static void main(String[] args) throws SQLException {
        // DB Connection 객체 생성
        Connection con = getConnection();
        if(con != null){
            try {
                // Statement 생성
                Statement stmt = con.createStatement();

                // Query
                String selTest = "SELECT * FROM beverage";
                // 결과 값 담기     쿼리 실행
                ResultSet rs = stmt.executeQuery(selTest);

                // 리스트 생성
                ArrayList<Beverage> beverList = new ArrayList<>();
                // 결과 처리
                while (rs.next()){
                    Beverage bever = new Beverage();
                    bever.setNo(rs.getInt("id"));
                    bever.setName(rs.getString("name"));
                    bever.setKind(rs.getString("kind"));
                    bever.setPrice(rs.getInt("price"));
                    beverList.add(bever);
                }

                // 출력
                System.out.printf("%4s %10s %10s %8s\n", "ID", "NAME", "KIND", "PRICE");
                for (Beverage bever : beverList){
                    System.out.printf("%4d %10s %10s %8d\n",
                        bever.getNo(),
                        bever.getName(),
                        bever.getKind(),
                        bever.getPrice());
                }

                // 자원해제
                rs.close();
                stmt.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        con.close();
    }
}
