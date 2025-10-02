-- 변환
-- 반올림을 할 수 있고 2번째 인자로 들어오는 부분부터 반올림 할 수 있다.
SELECT
	round(1234.5678) AS round01,
	round(1234.5678, 0) AS round02,
	round(1234.5678, 1) AS round03,
	round(1234.5678, 2) AS round04,
	round(1234.5678, -1) AS round05,
	round(1234.5678, -2) AS round06_1,
	round(1254.5678, -2) AS round06_2
FROM
	dual;
-- trunc는 무조건 버림 
SELECT
	trunc(1234.5678) AS trunc01,
	trunc(1234.5678, 0) AS trunc02,
	trunc(1234.5678, 1) AS trunc03,
	trunc(1234.5678, 2) AS trunc04,
	trunc(1234.5678, -1) AS trunc05,
	trunc(1234.5678, -2) AS trunc06_1,
	trunc(1254.5678, -2) AS trunc06_2
FROM
	dual;

SELECT
	-- ceil은 올림, floor는 내림
	ceil(1234.5678) AS ceil01,
	floor(1234.5678) AS floor01,
	-- 음수일 때는 과정이 반대여서 결과도 반대로 나옴
	ceil(-1234.5678) AS ceil02,
	floor(-1234.5678) AS floor02
FROM
	dual;

SELECT
	-- mod : 나머지 연산
	MOD(15, 6) AS ceil01,
	MOD(15, 5) AS ceil02
FROM
	dual;
-- 날짜 (매우 중요)

SELECT
	sysdate,
	systimestamp,
	-- 정밀하게 쓰는 경우
	current_timestamp
	-- 타임존이 다른 나라인경우
FROM
	dual;

SELECT
	sysdate AS nowdate,
	sysdate + 1 AS tomorrow,
	sysdate - 1 AS yesterday
FROM
	dual;
-- add_months 해서 윤년 까지 계산된 달을 넣어줌
SELECT
	sysdate AS nowdate,
	add_months(sysdate, 3) AS month3After
FROM
	dual;

SELECT
	empno,
	ename,
	HIREDATE,
	ADD_MONTHS(HIREDATE, 120) AS work10year
FROM
	emp;
-- 입사한지 40년 지난 사원 출력
SELECT
	empno,
	ename,
	HIREDATE
FROM
	emp
WHERE
	ADD_MONTHS(hiredate, 40 * 12) < sysdate;
-- between은 큰 날짜 - 작은 날짜로 해서 양수가 나오게 할 수 있음(달 차이)
SELECT
	empno,
	ename,
	HIREDATE,
	floor(months_between(sysdate, hiredate)) AS month01,
	trunc(months_between(sysdate, hiredate)) AS month02
FROM
	emp;
-- 다음주를 출력
SELECT 
	next_day(sysdate, 'Monday'),
	next_day(sysdate, 'Saturday')
FROM
	dual;
-- 한국어로 요일을 찾는 경우 여기서 ALTER는 수정을 의미함
ALTER SESSION SET
NLS_DATE_LANGUAGE = 'KOREAN';

SELECT 
	next_day(sysdate, '월요일')
FROM
	dual;
-- 영어로 다시 원복
ALTER SESSION SET
NLS_DATE_LANGUAGE = 'AMERICAN';

SELECT 
	next_day(sysdate, 'MONDAY')
FROM
	dual;
-- 마지막 날짜(현재 달의 마지막날 출력)
SELECT 
	last_day(sysdate)
FROM
	dual;
-- trunc로 시간을 절사
SELECT 
	sysdate, 
	trunc(sysdate) AS "일단위 절사",
	trunc(sysdate, 'MM') AS "월단위 절사",
	trunc(sysdate, 'yyyy') AS "년단위 절사",
	-- 분기 : 'Q'->Quoter
	trunc(sysdate, 'Q') AS "연분기단위 절사",
	trunc(sysdate, 'HH') AS "시단위 절사",
	trunc(sysdate, 'mi') AS "분단위 절사"
FROM
	dual;
-- round로 시간을 반올림
SELECT 
	sysdate, 
	round(sysdate) AS "일단위 절사",
	round(sysdate, 'MM') AS "월단위 절사",
	round(sysdate, 'yyyy') AS "년단위 절사",
	-- 분기 : 'Q'->Quoter
	round(sysdate, 'Q') AS "연분기단위 절사",
	round(sysdate, 'HH') AS "시단위 절사",
	round(sysdate, 'mi') AS "분단위 절사"
FROM
	dual;
-- 형 변환 type casting
SELECT
	empno,
	ename,
	empno + '500'
FROM
	emp
WHERE
	ename = 'SCOTT';
-- 묵시적 형변환
SELECT
	'1000' + empno,
	ename,
	empno + '500'
FROM
	emp
WHERE
	ename = 'SCOTT';
-- to_char, to_number, to_date(형변환은 3가지 밖에 없다.)
-- to_char 날짜를 문자로 변환
SELECT
	sysdate
FROM
	dual;
-- 포멧에 맞는 문자열 출력 가능
-- 클라리언트 에서 데이터를 줄 떄 2025/09/24 와 같은 형식의 포멧을 맞추는 경우
SELECT
	to_char(sysdate, 'yyyy/mm/dd'),
	to_char(sysdate, 'yyyy/mm/dd HH:mi:ss') AS date01,
	to_char(sysdate, 'yyyy/mm/dd HH24:mi:ss') AS date02,
	to_char(sysdate, 'CC') AS date03,
	to_char(sysdate, 'MON') AS date04,
	to_char(sysdate, 'MONTH', 'NLS_DATE_LANGUAGE = KOREAN') AS date05,
	-- 여기도 한글 적용 할 수 있음
	to_char(sysdate, 'DDD') AS date06,
	-- 해당 년도 일
	to_char(sysdate, 'DY') AS date07,
	-- 요일 (간략히)
	to_char(sysdate, 'DAY', 'NLS_DATE_LANGUAGE = KOREAN') AS date08,
	-- 요일 (풀네임), 한글 적용 가능
	to_char(sysdate, 'W') AS date09
	-- 주
FROM
	dual;
-- select 안에 절대 공백을 만들지 말 것
--fm 을 붙이면 공백이 지워진다.
SELECT
	to_char(12345.67) AS num01,
	to_char(12345.67, '00,000.00') AS num02,
	to_char(12345.67, '0000000.99') AS num03,
	-- 포멧에서는 0과 9만 쓸 수 있음.. 0은 0으로 채우고 9는 공백으로 처리
	to_char(12345.67, '9999999.99') AS num04,
	to_char(12345, 'L9999999') AS num05,
	to_char(12345, 'fm9,999,999') || '원' AS num06
	--	to_char(12345, 'L9999999', 'NLS_TERRITORY = KOREA') AS num06
FROM
	dual;
-- to_number
SELECT
	1300 - '1500'
FROM
	dual;

SELECT
	to_number('1,300', '999,999') - to_number('1,500', '999,999') AS calculate
FROM
	dual;
--SELECT to_number('1,300', '000,000') - to_number('1,500', '000,000') AS calculate FROM dual;
-- to_date : 많이 쓰임 
SELECT
	to_date('2025/09/24', 'yyyy-MM-dd') AS CURRENTdate
	-- 자동으로 인식하는 경우도 있지만
FROM
	dual;
-- 구분하는 형식을 맞춰주는게 좋다.
SELECT
	to_date('2025/09/24', 'yyyy/MM/dd') AS CURRENTdate
FROM
	dual;
-- 1981년 6월 1일 이후에 입사한 출력
SELECT
	ename,
	hiredate
FROM
	emp
	--WHERE to_number(REPLACE(to_char(hiredate, 'yyyy/mm/dd'), '/'), '99999999') > 19810601;
WHERE
-- date끼리는 부등호 비교가 가능
	to_date('1981-06-01', 'yyyy-mm-dd') < hiredate;
-- null 처리함수 nvl, nvl2
SELECT
	sal + nvl(comm, 0)
FROM
	emp;
-- null 값이 있으면 초기값을 0으로 처리
SELECT
	sal,
	comm,
	nvl2(comm, 'O', 'X')
FROM
	emp;
-- 만약 있으면 sal, 없으면 no commition
SELECT
	sal,
	comm,
	nvl2(comm, to_char(sal), 'no commition') AS RESULT
FROM
	emp;

SELECT
	sal,
	comm,
	nvl2(comm, to_char(comm, 'fm999,999,999.00'), 'no commition') AS commition
FROM
	emp;
-- 연봉 출력 -- comm + sal * 12
SELECT
	ename,
	sal,
	comm,
	to_number((sal + nvl(comm, 0)) * 12) AS annualsal
FROM
	emp;

SELECT
	ename,
	sal,
	nvl2(comm, 'O', 'X') AS commition,
	comm,
	--	to_number((sal + nvl(comm, 0)) * 12) AS annualsal,
	nvl2(comm, comm + sal * 12, sal * 12) AS annualsal
FROM
	emp;
--decode 오라클 전용 : if 문처럼 사용할 수 있다.
-- case when then ansi
-- salesman 연봉 10% 인상, manager 5% 인상, analyst 동결, 나머지는 인상
SELECT
	ename,
	job,
	sal, 
	decode(job,
		'SALESMAN', sal * 1.1,
		'MANAGER', sal * 1.05,
		'ANALYST', sal,
				    sal * 1.03
	) AS up_sal
FROM
	emp;
-- case when else end 가 표준이다
SELECT
	ename,
	job,
	sal, 
	CASE
		job
		WHEN 'SALESMAN' THEN sal * 1.1
		WHEN 'MANAGER' THEN sal * 1.05
		WHEN 'ANALYST' THEN sal * 1
		ELSE sal * 1.03
	END AS up_sal
FROM
	emp;
-- 위와는 다르게 공통으로 쓰지 않는 경우(복잡할 떄)
SELECT
	ename,
	job,
	sal, 
	CASE 
		WHEN job = 'SALESMAN' THEN sal * 1.1
		WHEN job = 'MANAGER' THEN sal * 1.05
		WHEN job = 'ANALYST' THEN sal * 1
		ELSE sal * 1.03
	END AS up_sal
FROM
	emp;
-- commition을 가지고 null이면 commtion 해당사항없음, 0이면 수당없음, 있으면 수당 : 3000

SELECT
	ename,
	job,
	comm, 
	CASE
		WHEN comm IS NULL THEN '해당사항없음'
		WHEN comm = 0 THEN '수당없음'
		ELSE concat('수당 : ', comm)
	END AS up_sal
FROM
	emp;
-- p.179 quiz
--- 0.
SELECT
	empno,
	rpad(substr(empno, 1, 2), LENGTH(empno), '*') AS masking_empno,
	ename,
	rpad(substr(ename, 1, 1), LENGTH(ename), '#')AS masking_ename
FROM
	emp
WHERE LENGTH(ename) >= 5;

--- 1.
SELECT 
	empno,
	ename,
	sal,
	trunc((sal / 21.5), 2) AS day_pay1,				-- trunc는 오라클 전용
	floor((sal / 21.5 * 100)) / 100 AS day_pay2,	-- floor는 표준
	round((sal / 21.5 / 8), 1) AS time_pay
FROM 
	emp;
--- 2.
SELECT
	empno,
	ename,
	to_char(hiredate, 'yy/MM/dd') AS hiredate,
	to_char(next_day(add_months(hiredate, 3), 'monday'), 'yyyy-MM-dd') AS r_job,
	nvl2(comm, to_char(comm), 'N/A') AS comm
FROM 
	emp;
--- 3.
SELECT
	empno,
	ename,
	mgr,
	-- case 를 쓸때는 THEN을 빼먹지 말 것
	CASE 
		WHEN mgr IS NULL THEN '0000'
		WHEN floor(mgr / 100) = 75 THEN '5555'
		WHEN floor(mgr / 100) = 76 THEN '6666'
		WHEN floor(mgr / 100) = 77 THEN '7777'
		WHEN floor(mgr / 100) = 78 THEN '8888'
		ELSE to_char(mgr)
	END AS chg_mgr
--	CASE 
--		WHEN mgr IS NULL THEN '0000'
--		WHEN substr(mgr, 1, 2) = '75' THEN '5555'
--		WHEN substr(mgr, 1, 2) = '76' THEN '6666'
--		WHEN substr(mgr, 1, 2) = '77' THEN '7777'
--		WHEN substr(mgr, 1, 2) = '78' THEN '8888'
--		ELSE to_char(mgr)
--	END AS chg_mgr
FROM
	emp;

SELECT
	trunc(mgr / 100)
FROM
	emp;
