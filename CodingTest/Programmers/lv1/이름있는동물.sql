-- https://school.programmers.co.kr/learn/courses/30/lessons/59407

-- SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME is not null;
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE !ISNULL(NAME);