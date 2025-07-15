-- https://school.programmers.co.kr/learn/courses/30/lessons/133025

SELECT fh.FLAVOR FROM FIRST_HALF fh
INNER JOIN ICECREAM_INFO ii on fh.FLAVOR = ii.FLAVOR
WHERE fh.TOTAL_ORDER > 3000 AND ii.INGREDIENT_TYPE = 'fruit_based'
ORDER BY fh.TOTAL_ORDER DESC;