-- 해당 테이블은 오로지 SYS 계정에서만 볼 수 있다.
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_USERS WHERE USERNAME = 'SCOTT';

-- 해당 계정에 뷰 생성 권한 부여

-- 그리고 그 권한은 항상 SYS같은 관리자 계정에서 권한을 부여해야한다.
GRANT CREATE VIEW TO SCOTT;

-- SEQUECE를 SCOTT에 계정 권한을 넘겨야한다.
GRANT CREATE SEQUENCE TO SCOTT;

GRANT CREATE SYNONYM TO SCOTT;

-- 사용자