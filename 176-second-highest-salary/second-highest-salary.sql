# Write your MySQL query statement below
select(Select distinct salary a
from employee
order by salary desc
limit 1 offset 1) as SecondHighestSalary;
