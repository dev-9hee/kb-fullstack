USE employees;

-- 직원수
SELECT count(*) FROM dept_emp
WHERE to_date = '9999-01-01'; -- '9999/01/01'

-- 내부 조인
USE sqldb;
SELECT *
FROM buytbl b INNER JOIN usertbl u
ON b.userID = u.userID
ORDER BY b.userID;

-- 왼쪽 외부 조인
SELECT u.userID, u.name, b.prodName, u.addr, CONCAT(u.mobile1, u.mobile2) AS 연락처
FROM usertbl u LEFT OUTER JOIN buytbl b ON u.userID = b.userID
ORDER BY u.userID;

-- 3개의 테이블 조인
USE sakila;
-- SELECT a.first_name, a.last_name, f.title
-- SELECT f.title, a.* // a는 모두 출력
-- SELECT a.first_name, a.last_name, f.*
SELECT a.*, f.*
FROM film f 
	INNER JOIN film_actor fa
	ON f.film_id = fa.film_id
	INNER JOIN actor a
    ON fa.actor_id = a.actor_id
ORDER BY f.title;

