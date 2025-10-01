
-- 계정을 만들어야 함, sys는 건드리지 말것
-- 반드시 계정을 만들어서 사용
ALTER SESSION SET "_oracle_script" = TRUE;  --- 일회용
CREATE USER scott04 IDENTIFIED BY 1234; -- 원래는 이름에 c##scott04가 생겨야함
-- connection을 만든다는 건 session을 만든다는 소리

-- 권한은 항상 sys(관리자)가 주어야 함.
GRANT CREATE SESSION TO scott04;

-- 위는 세션만 만드는 권한만 주고 테이블을 만들 권한을 아직 주지 않음
GRANT CREATE TABLE TO scott04; -- 테이블을 만들 권한

-- create table이 귀찮으면 role을 쓴다.

-- INSERT 할 수 있는 권한 부여 키워드
ALTER USER SCOTT04 QUOTA 500M ON USERS; -- 원래는 UNLIMITED 키워드를 사용한다.