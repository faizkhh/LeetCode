# Write your MySQL query statement below
WITH Filtered AS (
    SELECT *
    FROM Stadium
    WHERE people >= 100
),
Grouped AS (
    SELECT *,
           id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Filtered
),
ValidGroups AS (
    SELECT grp
    FROM Grouped
    GROUP BY grp
    HAVING COUNT(*) >= 3
)
SELECT id, visit_date, people
FROM Grouped
WHERE grp IN (SELECT grp FROM ValidGroups)
ORDER BY visit_date;
