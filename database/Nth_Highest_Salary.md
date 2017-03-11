http://dba.stackexchange.com/questions/99245/how-to-find-the-nth-highest-salary-in-sql
https://leetcode.com/problems/nth-highest-salary/?tab=Description

```sql
SELECT MAX(Salary) as SecondHighestSalary FROM Employee WHERE Salary <> (SELECT MAX(Salary) FROM Employee)
```
```sql
#为了得到null才加的Salary
SELECT MAX(Salary) as SecondHighestSalary FROM Employee E1
WHERE 1 = (SELECT COUNT(DISTINCT(E2.Salary)) FROM Employee E2
WHERE E2.Salary > E1.Salary);
```
```sql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      SELECT MAX(Salary) as SecondHighestSalary FROM Employee E1
        WHERE N-1 = (SELECT COUNT(DISTINCT(E2.Salary)) FROM Employee E2
        WHERE E2.Salary > E1.Salary)
  );
END
```sql
