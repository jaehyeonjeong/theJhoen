SELECT * FROM movie;
SELECT * FROM audience;
SELECT * FROM viewing;

--10) ‘Avengers’를 본 관객들이 같이 본 다른 영화의 아이디, 제목, 장르, 개봉연도를 출력하시오.

-- 어벤저스를 본 관객들의 아이디
SELECT v.AUDIENCE_ID
FROM movie m
JOIN viewing v ON m.movie_id = v.movie_id
WHERE m.title = 'Avengers';

SELECT DISTINCT v.MOVIE_ID, m.title, m.GENRE, m.RELEASE_YEAR 
FROM viewing v
JOIN movie m ON m.MOVIE_ID = v.MOVIE_ID
WHERE v.AUDIENCE_ID > ALL (SELECT v.AUDIENCE_ID FROM movie m 
JOIN viewing v ON m.movie_id = v.movie_id WHERE m.title = 'Avengers'); -- 해당하는 것들



--9) 본 모든 영화의 평점이 9점 이상인 관객의 아이디와 이름을 출력하시오.
--1	8.66666666666666666666666666666666666667
--2	8
--3	7
--4	9.5
--5	7.66666666666666666666666666666666666667
-- 영화별 평점
SELECT v.MOVIE_ID, avg(v.rating) AS avg_rating
FROM audience a
JOIN viewing v ON a.audience_id = v.audience_id
GROUP BY v.MOVIE_ID;

--8) 어떠한 영화도 본 적이 없는 관객의 아이디와 이름을 출력하시오.(outer)
SELECT a.audience_id, a.name
FROM audience a
LEFT JOIN viewing v ON a.AUDIENCE_ID = v.AUDIENCE_ID
WHERE v.movie_id IS null;

--7) 개인 평균 평점이 전체 평균 평점보다 높은 관객의 아이디, 이름, 평균 평점을 출력하시오
-- 개인 평균 평점,
SELECT v.audience_id, a.name, avg(v.rating) AS avg_rating
FROM viewing v
JOIN audience a ON a.audience_id = v.AUDIENCE_ID
GROUP BY v.audience_id, a.name
HAVING avg(v.rating) > (SELECT avg(rating) FROM viewing);

-- 전체 평균 평점
SELECT avg(rating) FROM viewing;

--6) 가장 많이 관람된 영화(공동 1위 포함)의 아이디, 제목, 관람 수를 출력하시오.
-- 1. 관람한 영화별 아이디를 카운트후 최대값을 구함
SELECT  max(COUNT(*)) FROM VIEWING GROUP BY MOVIE_ID;

--2. 쿼리
SELECT m.movie_id, m.title, count(*)
FROM movie m
JOIN viewing v ON m.movie_id = v.movie_id
GROUP BY m.MOVIE_ID, m.TITLE
HAVING count(*) = (SELECT  max(COUNT(*)) FROM VIEWING GROUP BY MOVIE_ID);

-- 5) 2021년에만 영화를 본 관객의 아이디와 이름을 출력하시오 (2021년이 있고 AND 2021년이 아닌 년도)
SELECT v.AUDIENCE_ID, a.NAME, v.VIEW_DATE 
FROM viewing v
JOIN audience a ON a.audience_id = v.audience_id
WHERE to_char(to_date(v.VIEW_DATE), 'yyyy') = 2021 AND to_char(to_date(v.VIEW_DATE), 'yyyy') NOT IN (2020, 2022);

-- 뭔가 테이블 안에 한사람에 VIEW DATE가 하나밖에 없어서 위의 조건이 먹히는지는 감이 안잡힘
SELECT DISTINCT to_char(to_date(VIEW_DATE), 'yyyy') FROM viewing;
SELECT * 
FROM viewing v
JOIN audience a ON v.AUDIENCE_ID = a.AUDIENCE_ID
ORDER BY a.AUDIENCE_ID ;

--4) 관람 기록이 전혀 없는 영화의 아이디, 제목, 장르, 개봉연도를 출력하시오.  outer
SELECT m.MOVIE_ID, m.TITLE, m.GENRE, m.RELEASE_YEAR 
FROM MOVIE m 
LEFT JOIN VIEWING v ON m.MOVIE_ID = v.MOVIE_ID
WHERE v.MOVIE_ID IS NULL;


--3) 장르가 Sci-Fi인 영화를 본 적이 있는 관객의 아이디와 이름을 출력하시오.
SELECT movie_id FROM movie WHERE GENRE = 'Sci-Fi';

SELECT a.audience_id, a.name 
FROM audience a
JOIN viewing v ON a.AUDIENCE_ID = v.AUDIENCE_ID
WHERE v.MOVIE_ID IN (SELECT movie_id FROM movie WHERE GENRE = 'Sci-Fi');

--1) 2편 이상 영화를 본 관객의 아이디와 이름을 출력하시오.
SELECT count(*) 
FROM viewing
GROUP BY audience_id;

SELECT DISTINCT a.audience_id, a.name
FROM audience a
JOIN viewing v ON (a.audience_id = v.audience_id)
WHERE 1 < ALL (SELECT count(*) FROM viewing GROUP BY audience_id);


--2) 영화별 평균 평점이 전체 영화 평균 평점보다 높은 영화의 아이디, 제목, 평균 평점을 출력하시오.
-- 나눠야할 쿼리 1) 영화별 평균 평점
SELECT M.MOVIE_ID, M.TITLE, FLOOR(AVG(V.RATING)) AS AVG_RATING
FROM VIEWING V
JOIN MOVIE M ON M.MOVIE_ID = V.MOVIE_ID
GROUP BY M.MOVIE_ID, M.TITLE
HAVING AVG(RATING) > (SELECT AVG(RATING) FROM VIEWING);

---2) 전체 영화 평균 평점
SELECT AVG(RATING) FROM VIEWING;



