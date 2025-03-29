# Write your MySQL query statement below
select 
case
WHEN MOD(id, 2) = 1 AND LEAD(id) OVER () IS NOT NULL THEN id + 1
        WHEN MOD(id, 2) = 0 THEN id - 1
        ELSE ID
END AS ID, STUDENT
FROM SEAT
ORDER BY ID;