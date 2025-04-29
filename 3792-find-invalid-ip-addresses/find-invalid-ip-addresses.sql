# Write your MySQL query statement below
SELECT ip, COUNT(*) AS invalid_count
FROM logs
WHERE
    -- 1. Invalid if not exactly 4 parts
    LENGTH(ip) - LENGTH(REPLACE(ip, '.', '')) != 3

    -- OR 2. Any octet has leading zeros (must not match ^0[0-9])
    OR REGEXP_LIKE(ip, '\\.0[0-9]+|^0[0-9]+')

    -- OR 3. Any octet > 255
    OR (
        CAST(SUBSTRING_INDEX(ip, '.', 1) AS UNSIGNED) > 255 OR
        CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 2), '.', -1) AS UNSIGNED) > 255 OR
        CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 3), '.', -1) AS UNSIGNED) > 255 OR
        CAST(SUBSTRING_INDEX(ip, '.', -1) AS UNSIGNED) > 255
    )
GROUP BY ip
ORDER BY invalid_count DESC, ip DESC;
