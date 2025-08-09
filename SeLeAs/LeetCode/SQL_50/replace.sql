# Write your MySQL query statement below
SELECT emp2.unique_id AS unique_id, emp.name AS name
FROM Employees emp
LEFT JOIN EmployeeUNI emp2
ON emp.id = emp2.id