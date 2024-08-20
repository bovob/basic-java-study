package com.mybatis;

/**
 * Mybatis
 * -> 자바 오브젝트와 SQL 사이 매핑기능을 지원하는
 * ORM(Object Relational Mapping) 프레임 워크다.
 *
 * JDBC를 통하여 RDBMS에 액세스하여 작업을 캡슐화하고
 * JDBC의 중복작업을 간소화 해 준다.
 *
 * XML 파일 형태로 Mapper를 통해 프로그램 코드로 부터 SQL 쿼리를 분리시킨다.
 *
 * 홈페이지 : mybatis.org
 * Docs : mybatis.org/mybatis-3/getting-started.html
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // sqlSessionFactory 인스턴스를 중심으로
        // Mybatis를 사용하게 된다.

        // mybatis 설정파일
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 생성순서
        // SQL Session Builder->Factory->Session
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        // SQL Session에서 Auto Commit 방법을 설정한다.
        // [ true : 활성화 | false : 비활성화 ]
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        /* 순서
        1. insert
        2. update
        3. delete
        4. select
         */

        // ****************** [ Insert ] ******************
        // 1. 고객정보 추가
        String name = "bovob";
        String email = "bovob@test.com";
        // 고객더미 생성
        Customer dummyCustomer = new Customer();
        dummyCustomer.setName(name);
        dummyCustomer.setEmail(email);
        // Insert 실행 - Parameter를 넘긴다.
        // select에서 나오지만 실제 db는 아직 적용되지 않았다.
        // 현재 AUTO COMMIT = FALSE;
        sqlSession.insert("CustomerDao.insert", dummyCustomer);

        // ****************** [ Update ] ******************
        // 2. 고객정보 추가
        String name2 = "서머시기";
        String email2 = "SEO@test.com";
        // 고객더미 생성
        Customer dummy2Customer = new Customer();
        dummy2Customer.setNo(10);
        dummy2Customer.setName(name2);
        dummy2Customer.setEmail(email2);
        // Update 실행
        sqlSession.update("CustomerDao.update", dummy2Customer);

        // ****************** [ Delete ] ******************
        // 3. 고객번호
        int num = 9;
        // Delete 실행
        sqlSession.delete("CustomerDao.delete", num);

        // ****************** [ Select ] ******************
        // 4. 고객정보(ResultSet)을 담을 List 선언
        List<Customer> customers;
        // Select 실행
        customers = sqlSession.selectList("CustomerDao.select");
        // List 출력
        for(Customer customer : customers){
            System.out.printf("%3d %-10s %-20s\n", customer.getNo(), customer.getName(), customer.getEmail());
        }

        // 롤백
        // sqlSession.rollback();
        // 커밋
        sqlSession.commit();
    }
}
