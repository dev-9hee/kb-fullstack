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
