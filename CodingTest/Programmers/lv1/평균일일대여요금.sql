-- https://school.programmers.co.kr/learn/courses/30/lessons/151136
-- 반올림 : ROUND(숫자, option:자리수) 
--      => 자리수 이하부터 버림 : 0이면 첫째자리에서 반올림, 1이면 둘째자리에서 반올림, -1이면 일의자리에서, -2면 십의자리에서, ...
-- 올림 : CEIL(숫자, option:자리수)
-- 내림 : FLOOR(숫자, option:자리수)
SELECT ROUND(AVG(DAILY_FEE), 0) as 'AVERAGE_FEE' from car_rental_company_car WHERE CAR_TYPE = 'SUV';