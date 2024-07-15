USE sqldb;
SELECT * FROM buytbl;

START TRANSACTION; -- 트랜잭션의 시작
DELETE FROM buytbl WHERE num = 1; -- 1번 행 삭제
DELETE FROM buytbl WHERE num = 2; -- 2번 행 삭제
SELECT * FROM buytbl; -- 테이블 확인

ROLLBACK; -- 가장 최근의 트랜젝션 시작 전 상태로 되돌리기
SELECT * FROM buytbl; -- 테이블 확인

-- AUTO COMMIT 모드 : 명령 실행 시 마다 COMMIT 자동 실행(디폴트)
SELECT @@autocommit; -- @@ : mySQL의 환경변수, 0이면 꺼져있는 상태, 1 : 실행하면 바로 커밋되는 상태
SET autocommit = false; -- 끄기