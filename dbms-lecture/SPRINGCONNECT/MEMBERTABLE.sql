-- 제약 사항 이름 붙이고 권한부여해서 테이블을 만들어 봐야한다.
-- 자동증가 시퀸스도 만들기 
-- 데이터 10개 입력

--DROP SEQUENCE MEMBER_SEQ;
--
--
DROP TABLE MEMBER;

-- 시퀀스 생성
CREATE SEQUENCE MEMBER_SEQ 
	START WITH 1
	INCREMENT BY 1
	MAXVALUE 9999999999
	MINVALUE 1
	NOCYCLE;

CREATE TABLE MEMBER (
 	ID NUMBER,
	USERID VARCHAR2(100),
	USERPW VARCHAR2(100) DEFAULT '1234',
	USERNAME VARCHAR2(100) CONSTRAINT MEMBER_USERNAME_NN NOT NULL,
	USEREMAIL VARCHAR2(100) CONSTRAINT MEMBER_USEREMAIL_NNUNIQ NOT NULL UNIQUE,
	CONSTRAINT MEMBER_ID_USERID_PK PRIMARY KEY (ID, USERID)
);

INSERT INTO MEMBER (ID, USERID, USERNAME, USEREMAIL)
VALUES (MEMBER_SEQ.NEXTVAL, 1111, '정재현', 'DEFINEJAE234@GMAIL.COM');
INSERT INTO MEMBER (ID, USERID, USERNAME, USEREMAIL)
VALUES (MEMBER_SEQ.NEXTVAL, 2222, '정다현', 'DEFINEDA234@GMAIL.COM');
INSERT INTO MEMBER (ID, USERID, USERNAME, USEREMAIL)
VALUES (MEMBER_SEQ.NEXTVAL, 3333, '정해영', 'DEFINEHAE234@GMAIL.COM');
INSERT INTO MEMBER (ID, USERID, USERPW, USERNAME, USEREMAIL)
VALUES (MEMBER_SEQ.NEXTVAL, 4444, 4444, '정민희', 'DEFINEMIN234@GMAIL.COM');
--INSERT INTO MEMBER (ID, USERID, USERNAME, USEREMAIL)
--VALUES (MEMBER_SEQ.NEXTVAL, 5555, '정해화', 'DEFINEHAE2234@GMAIL.COM');
--INSERT INTO MEMBER (ID, USERID, USERNAME, USEREMAIL)
--VALUES (MEMBER_SEQ.NEXTVAL, 6666, '정해복', 'DEFINEHAE3234@GMAIL.COM');
--INSERT INTO MEMBER (ID, USERID, USERNAME, USEREMAIL)
--VALUES (MEMBER_SEQ.NEXTVAL, 7777, '임종빈', 'DEFINEJONG5234@GMAIL.COM');
--INSERT INTO MEMBER (ID, USERID, USERNAME, USEREMAIL)
--VALUES (MEMBER_SEQ.NEXTVAL, 8888, '임종훈', 'DEFINEJONG2234@GMAIL.COM');
--INSERT INTO MEMBER (ID, USERID, USERNAME, USEREMAIL)
--VALUES (MEMBER_SEQ.NEXTVAL, 9999, '임하랑', 'DEFINEHA234@GMAIL.COM');
--INSERT INTO MEMBER (ID, USERID, USERNAME, USEREMAIL)
--VALUES (MEMBER_SEQ.NEXTVAL, 10000, '정약용', 'DEFINEYAK234@GMAIL.COM');


SELECT * FROM MEMBER;

delete from member where id='6' AND userID='6666' AND userPW='7777';
delete from member where id='21';

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'MEMBER';

-- 왠지 문제에 나올 듯 문자와 숫자로 정의된 COLUMN에서 DESC 갈기면 어떻게 되는지
SELECT * FROM MEMBER
ORDER BY ID DESC;

SELECT * FROM MEMBER
ORDER BY USERID DESC;


update member set userName='정재혀현', userEmail='definejae234@gmail.com' where id=1;

-- 긴급히 COLUMN 항목을 추가해야하는 경우	
ALTER TABLE MEMBER
	ADD USERPW VARCHAR2(100) DEFAULT '1234' CONSTRAINT MEMBER_USERPW_NN NOT NULL;

SELECT COUNT(*)
        FROM member
        WHERE userEmail='definejae234@gmail.com';








-- 시퀀스랑 테이블 생성 BOARD SEQ, TABLE
CREATE SEQUENCE BOARD_SEQ 
	START WITH 1
	INCREMENT BY 1
	MAXVALUE 9999999999
	MINVALUE 1
	NOCYCLE;

CREATE TABLE BOARD (
 	ID NUMBER CONSTRAINT BOARD_ID_PK PRIMARY KEY,
	TITLE VARCHAR2(3000) CONSTRAINT BOARD_TITLE_NN NOT NULL,
	CONTENT VARCHAR2(100) CONSTRAINT BOARD_CONTENT_NN NOT NULL,
	WRITER VARCHAR2(100) CONSTRAINT BOARD_WRITER_NN NOT NULL,
	REGDATE DATE DEFAULT SYSDATE,
	HIT NUMBER,
	PASSWORD VARCHAR2(100) 
);

insert into board(id, title, content, writer, regdate, hit, password) values
        (board_seq.nextval, '장발장', '테스트 입니다.', 'TEST USER', SYSDATE, 1, '1234');

SELECT * FROM BOARD;


delete from BOARD where id='2';



update member set userName='정재혀현', userEmail='definejae234@gmail.com' where id=1;

UPDATE board SET title='수정', content='수정', writer='수정', hit='2' WHERE id = 4;

SELECT * FROM BOARD;

DELETE FROM Board;
DROP SEQUENCE board_seq;

-- sql도 일반 프로그래밍이 가능하다.
-- pl/sql
BEGIN
	FOR	i IN .. 300 LOOP insert into board(id, title, content, writer, regdate, hit, password) values
        (board_seq.nextval, '테스트'||i, '테스트 본문입니다. 게시글 번호'||i, 
		CASE 
			WHEN MOD(i, 3) = 0 THEN '정재현'
			WHEN MOD(i, 3) = 1 THEN '정다현'
			ELSE '정해영'
		END, 
		SYSDATE, 1, '1234');
	END LOOP;
	COMMIT;
END;

BEGIN 
   FOR i IN 1..300 LOOP 
      insert into board(id,title,content,writer,regdate,hit,password) values
        (board_seq.nextval,'테스트'||i,'테스트 본문입니다. 게시글 번호'|| i,
      CASE 
         WHEN MOD(i,3) = 0 THEN '장성호'
         WHEN MOD(i,3) = 1 THEN '정형돈'
         ELSE '유재석'
      END,
      sysdate - DBMS_RANDOM.VALUE(0,30),1,'1234');
   END LOOP;
   COMMIT;
END;
-- ROWNUM : 유사 칼럼 -> pseudo column
SELECT ROWNUM AS NO, b.* FROM BOARD b ORDER BY regdate DESC;


-- 옛날 버전
SELECT * FROM (
SELECT ROWNUM AS NO, b.* FROM 
(SELECT id, writer, content, title, regdate, hit, password 
FROM board 
ORDER BY regdate) b
)
--WHERE NO <= 10;
WHERE NO >= 11 AND NO <= 20;



-- 최근 버전
SELECT id, writer, content, title, regdate, hit, password 
FROM board 
ORDER BY regdate DESC
offset 1 ROWS FETCH NEXT 10 ROWS ONLY;

-- 총 페이지 갯수, 몇개 끊을 건지 
SELECT count(*) AS total FROM board;

-- 검색
SELECT * FROM board WHERE title LIKE '%테스트%';

SELECT * FROM board WHERE title LIKE CONCAT(CONCAT('%','테스트15'),'%');

-- 이전글
SELECT * FROM board 
WHERE id < 299 
ORDER BY id desc
FETCH FIRST 1 ROWS ONLY;

-- 다음글
SELECT * FROM board 
WHERE id > 299 
ORDER BY id asc
FETCH FIRST 1 ROWS ONLY;


-- 이전글
SELECT * FROM board 
WHERE id < 299 AND WRITER LIKE '%유재%'
ORDER BY id desc


SELECT * FROM board WHERE id = 301;
SELECT * FROM MEMBER;

SELECT id,writer,title,content,regdate,hit, password FROM board;

CREATE TABLE board (
                       id        NUMBER PRIMARY KEY,
                       writer    VARCHAR2(100) NOT NULL,
                       title     VARCHAR2(3000) NOT NULL,
                       content   VARCHAR2(3000) NOT NULL,
                       regdate   DATE DEFAULT SYSDATE,
                       hit       NUMBER,
                       password  VARCHAR2(100)
);

ALTER TABLE board
    ADD secretValue CHAR(1) DEFAULT 'N'
        CONSTRAINT board_secretValue_ck CHECK (secretValue IN ('Y', 'N'));

ALTER TABLE board
    ADD secretPW VARCHAR2(100);



--비밀게시글 삽입 예시
INSERT INTO board (id, title, content, writer, regdate, hit, password, secretValue, secretPW)
VALUES (board_seq.nextval, '비밀글 제목', '비밀 내용', 'jjang051', SYSDATE, 0, '1234', 'N', '5678');

--전체 게시글 비밀글 표시 포함
SELECT id, title, writer, secretValue, secretPW FROM board WHERE secretValue = 'Y';
--비밀게시글만 필터링
SELECT * FROM board WHERE secretValue = 'Y';

INSERT INTO board (id, title, content, writer, regdate, hit, password, secretValue, secretPW)
VALUES (board_seq.nextval, '비밀글 제목1', '비밀 내용1', 'jjang0511', SYSDATE, 0, '1234', 'N', '56781');

INSERT INTO board (id, title, content, writer, regdate, hit, password, secretValue, secretPW)
VALUES (board_seq.nextval, '비밀글 제목11', '비밀 내용11', 'jjang05111', SYSDATE, 0, '1234', 'Y', '567811');


SELECT secretpw
FROM board
WHERE id = 305
  AND secretValue = 'Y';

UPDATE board
SET secretPW = 123456767
WHERE id = 307;

SELECT * FROM board WHERE id = 305;

UPDATE board
SET title = '수정된 제목',
    content = '수정된 본문입니다.',
    writer = '수정된 작성자입니다'
WHERE id = 1523;

SELECT * FROM board ORDER BY id desc;

SELECT * FROM MEMBER;


SELECT
    b.id,
    b.title,
    b.content,
    b.regdate,
    b.hit,
    b.secretValue,
    m.userid AS writer_id,
    m.username AS writer_name
FROM board b
JOIN member m ON b.writer = m.userid;

SELECT * FROM board WHERE writer = 'definejae234';

CREATE TABLE copy_board AS
SELECT * FROM board;

SELECT * FROM copy_board ORDER BY id desc;

ALTER TABLE copy_board
DROP COLUMN USERID;

ALTER TABLE board
ADD userid VARCHAR2(20);

ALTER TABLE board
ADD CONSTRAINT member_nickname_uq UNIQUE(userid);

SELECT * FROM board ORDER BY id desc;

SELECT * FROM MEMBER;

UPDATE board
SET USERID = 'definejae234'
WHERE ID = 306;


UPDATE copy_board
SET USERID = 'definejae234'
WHERE ID = 313;


ALTER TABLE copy_board
ADD CONSTRAINT fk_copy_board_userid
FOREIGN KEY(userid)
REFERENCES member(userid);


SELECT *
FROM copy_board b
JOIN member m ON b.userid = m.userid;

SELECT * FROM MEMBER;
SELECT * FROM board ORDER BY id desc;


SELECT
    b.id,
    b.userid,
    b.title,
    b.content,
    b.regdate,
    b.hit,
    b.secretValue,
    m.userid   AS writer_id,
    m.username AS writer_name
FROM copy_board b
JOIN member m ON b.userid = m.userid
WHERE m.userid = 'definejae234'
ORDER BY b.id DESC;


-- 시퀀스랑 테이블 생성 BOARD SEQ, TABLE
CREATE SEQUENCE BOARD_SEQ 
	START WITH 1
	INCREMENT BY 1
	MAXVALUE 9999999999
	MINVALUE 1
	NOCYCLE;

CREATE TABLE BOARD (
 	ID NUMBER CONSTRAINT BOARD_ID_PK PRIMARY KEY,
	TITLE VARCHAR2(3000) CONSTRAINT BOARD_TITLE_NN NOT NULL,
	CONTENT VARCHAR2(100) CONSTRAINT BOARD_CONTENT_NN NOT NULL,
	WRITER VARCHAR2(100) CONSTRAINT BOARD_WRITER_NN NOT NULL,
	REGDATE DATE DEFAULT SYSDATE,
	HIT NUMBER,
	PASSWORD VARCHAR2(100) 
);

-- 시퀀스 생성
CREATE SEQUENCE MEMBER_SEQ 
	START WITH 1
	INCREMENT BY 1
	MAXVALUE 9999999999
	MINVALUE 1
	NOCYCLE;

CREATE TABLE MEMBER (
 	ID NUMBER,
	USERID VARCHAR2(100),
	USERPW VARCHAR2(100) DEFAULT '1234',
	USERNAME VARCHAR2(100) CONSTRAINT MEMBER_USERNAME_NN NOT NULL,
	USEREMAIL VARCHAR2(100) CONSTRAINT MEMBER_USEREMAIL_NNUNIQ NOT NULL UNIQUE,
	CONSTRAINT MEMBER_ID_USERID_PK PRIMARY KEY (ID, USERID)
);

ALTER TABLE member
    ADD CONSTRAINT member_userid_unq UNIQUE (userid);

ALTER TABLE board
    ADD CONSTRAINT fk_board_userid
        FOREIGN KEY(userid)
            REFERENCES member(userid);

SELECT * FROM board ORDER BY id desc;

INSERT INTO MEMBER (id, userid, userpw, username, useremail)
VALUES (member_seq.nextval, 'definejae234', 1234, '정재현', 'definejae234');


INSERT INTO board (id, title, content, writer, regdate, hit, password, secretValue, secretPW, userID)
VALUES (board_seq.nextval, '비밀글 제목11', '비밀 내용11', 'definejae234', SYSDATE, 0, '1234', 'Y', '567811', 'definejae234');


SELECT
    b.id,
    b.userid AS writer_id,
    b.title,
    b.content,
    b.regdate,
    b.hit,
    m.userid AS real_id,
    m.username AS writer_name
FROM board b
         JOIN member m ON b.userid = m.userid
where m.userid = 'definejae234'
ORDER BY b.id DESC
offset 11 ROWS FETCH NEXT 10 ROWS ONLY;


SELECT * FROM board  ORDER BY id DESC;
SELECT * FROM MEMBER;


BEGIN 
   FOR i IN 1..20 LOOP 
      insert into board(id,title,content,writer,regdate,hit,password,secretValue,secretPW, userid) values
        (board_seq.nextval,'테스트'||i,'테스트 본문입니다. 게시글 번호'|| i,
      '정재현',
      sysdate - DBMS_RANDOM.VALUE(0,30),1,'1234', N, NULL, 'definejae234');
   END LOOP;
   COMMIT;
END;
-- ROWNUM : 유사 칼럼 -> pseudo column
SELECT ROWNUM AS NO, b.* FROM BOARD b ORDER BY regdate DESC;

SELECT count(*) FROM board WHERE userid = 'definejae234';

INSERT INTO board (id, title, content, writer, regdate, hit, password, secretValue, secretPW, userID)
VALUES (board_seq.nextval, '비밀글 제목11', '비밀 내용11', 'definejae234', SYSDATE, 0, '1234', 'Y', '567811', 'definejae234');

BEGIN
    FOR i IN 1..20 LOOP
        INSERT INTO board (
            id, title, content, writer, regdate, hit,
            password, secretValue, secretPW, userID
        ) VALUES (
            board_seq.nextval,
            '비밀글 제목' || i,
            '비밀 내용' || i,
            'definejae234',
            SYSDATE,
            0,
            '1234',
            'N',
            '567811',
            'definejae234'
        );
    END LOOP;
    COMMIT;
END;


--신준이 준거
DROP TABLE board;

DROP SEQUENCE board_seq;

CREATE TABLE board  (
                        id NUMBER CONSTRAINT board_id_pk PRIMARY KEY,
                        writer  varchar2(100) CONSTRAINT board_writer_nn NOT NULL,
                        title   varchar2(3000) CONSTRAINT board_title_nn NOT NULL,
                        content varchar2(3000) CONSTRAINT board_content_nn NOT NULL,
                        regdate DATE DEFAULT sysdate,
                        hit NUMBER,
                        password varchar2(100)
);

CREATE SEQUENCE board_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 99999999999999
    MINVALUE 1
    nocycle;



ALTER TABLE board
    ADD secretValue CHAR(1) DEFAULT 'N'
        CONSTRAINT board_secretValue_ck CHECK (secretValue IN ('Y', 'N'));

ALTER TABLE board
    ADD secretPW VARCHAR2(100);

ALTER TABLE board
    ADD userid VARCHAR2(100);



INSERT INTO board (id, title, content, writer, regdate, hit, password, secretValue, secretPW,userid)
VALUES (board_seq.nextval, '비밀글 제목', '비밀 내2용', '정재현', SYSDATE, 0, '1234', 'Y', '5678','definejae234');

BEGIN
    FOR i IN 1..20 LOOP
        INSERT INTO board (
            id, title, content, writer, regdate, hit,
            password, secretValue, secretPW, userID
        ) VALUES (
            board_seq.nextval,
            '비밀글 제목' || i,
            '비밀 내용' || i,
            '고양이',
            SYSDATE,
            0,
            '1234',
            'N',
            NULL,
            '5555'
        );
    END LOOP;
    COMMIT;
END;

DROP TABLE MEMBER;

SELECT * FROM MEMBER;

SELECT * FROM jpa_member;


