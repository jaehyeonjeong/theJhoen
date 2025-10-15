ALTER SESSION SET "_oracle_script" = TRUE;  --- 일회용 C## 쓰는거 방지
CREATE USER springjae234 IDENTIFIED BY 1234;

-- 권한은 항상 sys(관리자)가 주어야 함.
GRANT CREATE SESSION TO springjae234;

-- 위는 세션만 만드는 권한만 주고 테이블을 만들 권한을 아직 주지 않음
GRANT CREATE TABLE TO springjae234; -- 테이블을 만들 권한

GRANT CREATE SEQUENCE TO springjae234;


CREATE ROLE my_role;
GRANT 
    CREATE SESSION,
    CREATE SEQUENCE,
    CREATE VIEW,
    CREATE synonym,
    CONNECT,
    resource
TO my_role;
GRANT unlimited tablespace TO springjae234;
GRANT my_role TO springjae234;

--ALTER USER SPTINGJAE234 QUOTA UNLIMITED ON USERS;