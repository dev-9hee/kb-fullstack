-- 데이터베이스 생성
CREATE DATABASE mydb2;
-- 데이터베이스 사용 선택
USE mydb2;
-- 통합 테이블 생성, 정규화가 안 된 물품 주문 목록 테이블 생성
CREATE TABLE total_table (
    order_id INT,
    customer_id INT,
    customer_name VARCHAR(100),    
    order_date DATE,
    product_id INT,
    product_name VARCHAR(100),
    product_price INT,
    category_id INT,
    category_name VARCHAR(100),
    quantity INT
);

-- 통합 테이블에 데이터 삽입, 필요 데이터 삽입
INSERT INTO total_taBLE (order_id, customer_id, customer_name, order_DATE, PRODuct_id, produCt_name, Product_price, category_id, Category_namE, quantity) VALUES
(1, 1, '김시완', '2024-06-01', 1, '맥북에어', 650000, 1, '전자기기', 1),
(1, 1, '김시완', '2024-06-01', 4, '맥북 파우치', 10000, 2, '주변기기', 1),
(2, 2, '이효석', '2024-06-02', 2, '맥북프로', 700000, 1, '전자기기', 1),
(3, 3, '김연비', '2024-06-03', 3, '맥북프로맥스', 750000, 1, '전자기기', 1),
(4, 4, '최호진', '2024-06-04', 5, 'DT-35키보드', 20000, 2, '주변기기', 1),
(5, 5, '최현수', '2024-06-05', 6, '독거미키보드', 50000, 2, '주변기기', 1),
(6, 6, '김동준', '2024-06-06', 6, '독거미키보드', 50000, 2, '주변기기', 1),
(7, 7, '권오현', '2024-06-07', 6, '독거미키보드', 50000, 2, '주변기기', 1);

-- 테이블 및 삽입된 데이터 확인
SELECT * FROM total_table;


-- DROP TABLE total_table; -- 테이블 삭제
-- DELETE FROM total_table; -- 필드 삭제..?
-- DELETE FROM total_table WHERE customer_name = '이효석';