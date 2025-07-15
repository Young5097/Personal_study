-- https://school.programmers.co.kr/learn/courses/30/lessons/131528

-- SELECT count(*) AS USERS FROM USER_INFO WHERE AGE IS NULL;
SELECT count(*) AS USERS FROM USER_INFO WHERE ISNULL(AGE);