-- 데이터베이스 준비, 생성
CREATE DATABASE jdbc_ex;
-- 사용자 준비
CREATE USER 'jdbc_ex'@'%' IDENTIFIED BY 'jdbc_ex'; -- MySQL에서 새로운 사용자를 생성
-- jdbc_ex : user id(사용자 이름) / % : 접속 가능한 호스트, 접속 IP, %는 모든 IP 주소나 호스트에서 접속 가능함을 의미
-- IDENTIFIED BY 'jdbc_ex': 사용자 계정의 비밀번호를 설정
GRANT ALL PRIVILEGES ON jdbc_ex.* TO 'jdbc_ex'@'%'; -- 새로 생성된 사용자에게 특정 데이터베이스에 대한 모든 권한을 부여
FLUSH PRIVILEGES;