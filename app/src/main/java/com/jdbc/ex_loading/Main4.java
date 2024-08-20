package com.jdbc.ex_loading;

import java.io.FileReader;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *  ~/jdbc/ex1
 *
 *  Properties 사용하기
 *  설정값을 따로 빼내어 두고 불러와서 사용할 수 있다.
 *
 *  참조 :
 *  com/jdbc/jdbc-driver.properties
 *
 *  # application config
 *  jdbc.url=jdbc:mysql://localhost:3306/studydb
 *  jdbc.username=study
 *  jdbc.password=1111
 */

public class Main4 {

    public static void main(String[] args) {
        try {
            // Properties 불러오기
            Properties props = new Properties();
            props.load(new FileReader("./app/src/main/java/com/jdbc/jdbc-driver.properties"));
            System.out.println(props.getProperty("jdbc.url"));

            Driver driver = DriverManager.getDriver(props.getProperty("jdbc.url"));
            System.out.println(driver);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
