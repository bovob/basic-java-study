-- DB 생성
CREATE DATABASE IF NOT EXISTS basicdb
CHARACTER SET utf8mb4;

USE basicdb;

-- 테이블 삭제
DROP TABLE IF EXISTS customers RESTRICT;
DROP TABLE IF EXISTS orders RESTRICT;
DROP TABLE IF EXISTS beverage RESTRICT;

-- 고객 테이블 생성
CREATE TABLE customers (
    customer_id INT          NOT NULL                 COMMENT '고객ID',
    name        VARCHAR(100) NOT NULL                 COMMENT '고객이름',
    email       VARCHAR(100) NOT NULL                 COMMENT '고객Email'
) COMMENT='고객';

-- 주문 테이블 생성
CREATE TABLE orders (
    order_id    INT         NOT NULL                  COMMENT '주문ID',
    customer_id INT         NOT NULL                  COMMENT '고객ID',
    beverage_id INT         NOT NULL                  COMMENT '음료ID',
    order_date  TIMESTAMP                             COMMENT '주문시간'
) COMMENT='주문';

-- 음료 테이블 생성

CREATE TABLE beverage (
  id          INT           NOT NULL                  COMMENT '음료ID',
  name        VARCHAR(30)   NOT NULL                  COMMENT '이름',
  kind        VARCHAR(10)   NOT NULL                  COMMENT '종류',
  price       INT           NOT NULL                  COMMENT '가격'
) COMMENT='음료';



-- 제약조건

-- 고객 테이블 
ALTER TABLE customers
    ADD CONSTRAINT PK_customer  -- PK
    PRIMARY KEY (
      customer_id               -- 고객ID
    );

ALTER TABLE customers
MODIFY customer_id INT AUTO_INCREMENT;

-- 음료 테이블
ALTER TABLE beverage
    ADD CONSTRAINT PK_beverage  -- PK
    PRIMARY KEY (
      id -- 음료ID
    );

ALTER TABLE beverage
MODIFY id INT AUTO_INCREMENT;

-- 주문 테이블
ALTER TABLE orders
    ADD CONSTRAINT PK_order       -- PK
    PRIMARY KEY (
      order_id -- 주문ID               
    );

ALTER TABLE orders
MODIFY order_id INT AUTO_INCREMENT;

ALTER TABLE orders
    ADD CONSTRAINT FK_customer    -- FK
    FOREIGN KEY (
      customer_id -- 고객ID             
    ) 
    REFERENCES customers(
      customer_id -- 고객ID
    );

ALTER TABLE orders
    ADD CONSTRAINT FK_beverage    -- FK
    FOREIGN KEY (
      beverage_id -- 음료ID
    )
    REFERENCES beverage(
      id          -- 음료ID
    );


-- 인덱스
CREATE UNIQUE INDEX UIX_customer
    ON customers  (
       customer_id ASC,
       name        ASC
    );

CREATE UNIQUE INDEX UIX_order
    ON orders  (
       order_id  ASC
    );

CREATE INDEX IX_order
    ON orders  (
       order_date   ASC
    );

CREATE UNIQUE INDEX UIX_beverage
    ON beverage  (
       id     ASC,
       name   ASC
    );

CREATE INDEX IX_beverage
    ON beverage  (
       kind     ASC,
       price    ASC
    );

ALTER TABLE orders
ADD FOREIGN KEY (customer_id)
REFERENCES customers (customer_id)
ON DELETE CASCADE;