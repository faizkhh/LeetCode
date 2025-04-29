# Write your MySQL query statement below
WITH ConvertedUsers AS (
    SELECT user_id
    FROM UserActivity
    GROUP BY user_id
    HAVING 
        SUM(activity_type = 'free_trial') > 0 AND
        SUM(activity_type = 'paid') > 0
),

TrialAvg AS (
    SELECT user_id, 
           ROUND(AVG(activity_duration), 2) AS trial_avg_duration
    FROM UserActivity
    WHERE activity_type = 'free_trial'
      AND user_id IN (SELECT user_id FROM ConvertedUsers)
    GROUP BY user_id
),

PaidAvg AS (
    SELECT user_id, 
           ROUND(AVG(activity_duration), 2) AS paid_avg_duration
    FROM UserActivity
    WHERE activity_type = 'paid'
      AND user_id IN (SELECT user_id FROM ConvertedUsers)
    GROUP BY user_id
)

SELECT 
    t.user_id,
    t.trial_avg_duration,
    p.paid_avg_duration
FROM TrialAvg t
JOIN PaidAvg p ON t.user_id = p.user_id
ORDER BY t.user_id;
