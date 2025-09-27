-- 영화
CREATE TABLE movie (
  movie_id     NUMBER        CONSTRAINT pk_movie PRIMARY KEY,
  title        VARCHAR2(100) NOT NULL,
  genre        VARCHAR2(30),
  release_year NUMBER(4)
);

-- 관객
CREATE TABLE audience (
  audience_id  NUMBER        CONSTRAINT pk_audience PRIMARY KEY,
  name         VARCHAR2(50)  NOT NULL,
  age          NUMBER(3),
  gender       CHAR(1)       CHECK (gender IN ('M','F'))
);

-- 관람(조인 테이블)
CREATE TABLE viewing (
  movie_id     NUMBER        NOT NULL,
  audience_id  NUMBER        NOT NULL,
  view_date    DATE          NOT NULL,
  rating       NUMBER(2)     CHECK (rating BETWEEN 0 AND 10),
  CONSTRAINT pk_viewing PRIMARY KEY (movie_id, audience_id, view_date),
  CONSTRAINT fk_viewing_movie   FOREIGN KEY (movie_id)    REFERENCES movie(movie_id),
  CONSTRAINT fk_viewing_aud     FOREIGN KEY (audience_id) REFERENCES audience(audience_id)
);

-- (권장) 조인/검색용 인덱스
CREATE INDEX ix_viewing_aud ON viewing(audience_id, movie_id);
CREATE INDEX ix_viewing_movie ON viewing(movie_id, audience_id);

-- MOVIE
INSERT INTO movie VALUES (1, 'Inception',    'Sci-Fi',   2010);
INSERT INTO movie VALUES (2, 'Parasite',     'Thriller', 2019);
INSERT INTO movie VALUES (3, 'Avengers',     'Action',   2012);
INSERT INTO movie VALUES (4, 'Interstellar', 'Sci-Fi',   2014);
INSERT INTO movie VALUES (5, 'Oldboy',       'Thriller', 2003);
INSERT INTO movie VALUES (6, 'Dune',         'Sci-Fi',   2021); -- 관람기록 없음 (테스트용)

-- AUDIENCE
INSERT INTO audience VALUES (101, 'Alice',   30, 'F');
INSERT INTO audience VALUES (102, 'Bob',     25, 'M');
INSERT INTO audience VALUES (103, 'Charlie', 35, 'M');
INSERT INTO audience VALUES (104, 'Dana',    28, 'F');
INSERT INTO audience VALUES (105, 'Evan',    40, 'M');
INSERT INTO audience VALUES (106, 'Fay',     22, 'F'); -- 관람기록 없음 (테스트용)

-- VIEWING (view_date는 YYYY-MM-DD 사용)
INSERT INTO viewing VALUES (1, 101, TO_DATE('2020-01-01','YYYY-MM-DD'), 9);
INSERT INTO viewing VALUES (2, 101, TO_DATE('2020-02-01','YYYY-MM-DD'), 8);
INSERT INTO viewing VALUES (3, 101, TO_DATE('2020-03-01','YYYY-MM-DD'), 7);

INSERT INTO viewing VALUES (1, 102, TO_DATE('2021-01-10','YYYY-MM-DD'), 8);
INSERT INTO viewing VALUES (4, 102, TO_DATE('2021-02-10','YYYY-MM-DD'), 9);
INSERT INTO viewing VALUES (3, 102, TO_DATE('2021-03-10','YYYY-MM-DD'), 6);

INSERT INTO viewing VALUES (2, 103, TO_DATE('2020-05-01','YYYY-MM-DD'), 9);
INSERT INTO viewing VALUES (5, 103, TO_DATE('2020-06-01','YYYY-MM-DD'), 9);
INSERT INTO viewing VALUES (3, 103, TO_DATE('2020-07-01','YYYY-MM-DD'), 8);

INSERT INTO viewing VALUES (4, 104, TO_DATE('2022-01-01','YYYY-MM-DD'),10);
INSERT INTO viewing VALUES (1, 104, TO_DATE('2022-02-01','YYYY-MM-DD'), 9);
INSERT INTO viewing VALUES (5, 104, TO_DATE('2022-03-01','YYYY-MM-DD'), 6);

INSERT INTO viewing VALUES (2, 105, TO_DATE('2021-05-05','YYYY-MM-DD'), 7);
INSERT INTO viewing VALUES (5, 105, TO_DATE('2021-06-06','YYYY-MM-DD'), 8);

COMMIT;