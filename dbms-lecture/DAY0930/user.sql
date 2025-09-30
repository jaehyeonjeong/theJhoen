ALTER SESSION SET "_oracle_script" = TRUE;
CREATE USER orclstudy IDENTIFIED BY 1234; -- 계정 생성(아이디, 비밀번호)

-- 헤더 처럼 만드는 방식이 아래와 같다.
DEFAULT TABLESPACE users quota ON users;

-- session은 사용자가 db에 연결되면 session이 하나 생성됨.
GRANT CREATE SESSION TO orclstudy;


SELECT * FROM all_users WHERE username = 'orclstudy';
ALTER USER orclstudy IDENTIFIED BY 5678;

DROP USER orclstudy cascade; -- 사용자 삭제


--- 리소스 사용
GRANT RESOURCE, CREATE SESSION, CREATE TABLE TO orclstudy;

-- INSERT 하기위한 권한 부여
GRANT unlimited tablespace TO orclstudy;

-- 권한을 취소하기 위한 키워드 : revoke
REVOKE RESOURCE, CREATE TABLE FROM orclstudy;


-- role은 역할이다. 권한 여러개를 묶어서 역할로 만든다.
CREATE USER orclstudy02 IDENTIFIED BY 1234; -- 계정 생성(아이디, 비밀번호)
GRANT CONNECT, resource TO orclstudy02;
GRANT CONNECT, resource, dba TO orclstudy02;--  웬만한건 다들어가 있는 role이 dba role이다.
-- connect(alter session, create session)
-- connect는 role이다. create session, create sequence, create table


-- 귀찮다면 아래처럼 만든다
CREATE ROLE my_role;
GRANT 
	CREATE SESSION,
	CREATE TABLE,
	CREATE SEQUENCE,
	CREATE VIEW,
	CREATE synonym,
	CONNECT,
	resource
TO my_role;
GRANT unlimited tablespace TO orclstudy03;


ALTER USER orclstudy03 DEFAULT TABLESPACE users;
ALTER USER orclstudy03 quota 500m users;

CREATE USER orclstudy03 IDENTIFIED BY 1234; -- 계정 생성(아이디, 비밀번호)
GRANT my_role TO orclstudy03; -- my role이라는 권한들을 한번에 받음