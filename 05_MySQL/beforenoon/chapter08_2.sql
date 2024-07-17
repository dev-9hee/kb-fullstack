USE sakila; -- 디폴트 데이터베이스 : sakila

SELECT * FROM actor_info; -- actor_info 뷰 전체 내용 보기

USE sqldb; -- 디폴트 데이터베이스 : sqldb 

SELECT * FROM buytbl;

SELECT userID, sum(amount)
FROM buytbl
GROUP BY userID;

--  GROUP_CONCAT 함술르 사용해서 출연한 영화들을 출력
SELECT userID, GROUP_CONCAT(prodName SEPARATOR ', ') AS 목록
FROM buytbl
GROUP BY userID;

-- 뷰 생성 구문
USE tabledb; -- 내가 만든 데이터베이스 사용
CREATE VIEW v_usertbl -- 뷰를 만든다!
AS SELECT userID, uName, addr FROM usertbl; -- usertbl에서 userID, uName, addr 항목을 가져와서
SELECT * FROM v_usertbl; -- 뷰 보기, 뷰를 테이블이라고 생각해도 무방

-- 열의 추가
ALTER TABLE usertbl
ADD mobile1 CHAR(3) -- 열추가
DEFAULT '010' -- 디폴트 값 
NULL; -- NULL 허용함
-- 복잡 쿼리 단순화
DROP VIEW v_userbuytbl;
CREATE VIEW v_userbuytbl
AS
SELECT U.userid, U.uName, B.prodName, U.addr, CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U 
INNER JOIN buytbl B
ON U.userid = B.userid;
SELECT * FROM v_userbuytbl;