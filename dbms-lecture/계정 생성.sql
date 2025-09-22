--ALTER SESSION SET "_oracle_script" = TRUE;
--DROP USER scott;
--CREATE USER scott IDENTIFIED BY tiger 
--DEFAULT TABLESPACE users quota unlimited ON users;
--GRANT CREATE SESSION, CREATE TABLE TO scott;			--scott 계성 테이블 생성

DROP USER scott cascade; -- 권한 무시 후 삭제