-- 고객
INSERT INTO customers (customer_id, name, email) VALUES
(1, '김철수', 'chulsoo.kim@example.com'),
(2, '이영희', 'younghee.lee@example.com'),
(3, '박민수', 'minsoo.park@example.com'),
(4, '최수정', 'soojeong.choi@example.com'),
(5, '강다연', 'dayeon.kang@example.com'),
(6, '윤정우', 'jungwoo.yoon@example.com'),
(7, '장미영', 'miyeong.jang@example.com'),
(8, '한수현', 'soohyun.han@example.com'),
(9, '오준영', 'junyoung.oh@example.com'),
(10, '서지훈', 'jihun.seo@example.com');

-- 음료
INSERT INTO beverage (id, name, kind, price) VALUES
(1, '아메리카노', '커피', 3200),
(2, '카페 라떼', '커피', 3800),
(3, '카푸치노', '커피', 3700),
(4, '카페 모카', '커피', 3700),
(5, '카라멜 마끼아또', '커피', 3900),
(6, '화이트 초콜릿 모카', '커피', 3900),
(7, '민트 모카', '커피', 3800),
(8, '바닐라 라떼', '커피', 3700),
(9, '아인슈페너', '커피', 4700),
(10, '연유 카페라떼', '커피', 3700),
(11, '레몬 에이드', '에이드', 3800),
(12, '자몽 에이드', '에이드', 3800),
(13, '청포도 에이드', '에이드', 3800),
(14, '얼그레이 쉐이크', '쉐이크', 4800),
(15, '초코쿠키 쉐이크', '쉐이크', 4800),
(16, '딸기 쉐이크', '쉐이크', 4800);

-- 주문
INSERT INTO orders (order_id, customer_id, beverage_id, order_date) VALUES
(1, 1, 3, '2024-01-15 10:30:45'),
(2, 2, 5, '2024-02-22 12:45:30'),
(3, 3, 7, '2024-03-10 14:20:15'),
(4, 4, 2, '2024-04-08 09:55:00'),
(5, 5, 8, '2024-05-25 16:10:20'),
(6, 6, 12, '2024-06-14 11:40:50'),
(7, 7, 14, '2024-07-30 18:05:35'),
(8, 8, 10, '2024-08-03 08:20:30'),
(9, 9, 1, '2024-03-21 13:30:10'),
(10, 10, 16, '2024-07-11 15:50:25');