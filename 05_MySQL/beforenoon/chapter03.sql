SELECT * FROM employees.employees;

USE employees; -- 디폴트 데이터베이스를 employees로 설정
select * from employees;

select *			-- 모든 컬럼  
from employees;		-- 테이블명

USE shopdb;
SELECT memberName, memberAddress FROM memberTBL;
SELECT * FROM memberTBL WHERE memberName = '지운이';