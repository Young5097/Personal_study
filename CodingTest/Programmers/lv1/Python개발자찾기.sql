-- https://school.programmers.co.kr/learn/courses/30/lessons/276013
SELECT ID, email, first_name, last_name FROM DEVELOPER_INFOS
WHERE SKILL_1 = 'Python' or SKILL_2 = 'Python' or SKILL_3 = 'Python'
ORDER BY ID;

SELECT ID, email, first_name, last_name
FROM DEVELOPER_INFOS
WHERE 'Python' IN (SKILL_1, SKILL_2, SKILL_3)
ORDER BY ID;

SELECT ID, email, first_name, last_name
FROM DEVELOPER_INFOS
WHERE
    CASE
        WHEN SKILL_1 = 'Python' THEN 1
        WHEN SKILL_2 = 'Python' THEN 1
        WHEN SKILL_3 = 'Python' THEN 1
        ELSE 0
    END > 0
ORDER BY ID;