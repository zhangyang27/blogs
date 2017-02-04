##### 用SQL求得7日均和周均值

7日均：当天的数与前6天的数之和，求均值。示例代码会计算2日均。
周均值是：周一至周日的数之和，求均值。

直接看代码吧
```python
mysql> CREATE TABLE some_data1 (unique_id text, date date, value integer);
Query OK, 0 rows affected (0.01 sec)

mysql> INSERT INTO some_data1 (unique_id, date, value) VALUES
    ->  ( 'a', '2014-03-03', 5),
    ->  ( 'a', '2014-03-04', 5),
    ->  ( 'a', '2014-03-05', 3),
    ->  ( 'a', '2014-03-06', 9),
    ->  ( 'a', '2014-03-07', 1),
    ->  ( 'a', '2014-03-08', 1),
    ->  ( 'a', '2014-03-09', 1),
    ->  ( 'a', '2014-03-10', 1),
    ->  ( 'b', '2014-03-03', 1),
    ->  ( 'b', '2014-03-04', 1),
    ->  ( 'b', '2014-03-05', 2),
    ->  ( 'b', '2014-03-06', 3),
    ->  ( 'b', '2014-03-07', 4),
    ->  ( 'b', '2014-03-08', 4),
    ->  ( 'b', '2014-03-09', 4),
    ->  ( 'b', '2014-03-10', 4);
Query OK, 16 rows affected (0.00 sec)
Records: 16  Duplicates: 0  Warnings: 0

mysql> SELECT FROM_UNIXTIME(t1.date) AS date, t1.value , avg(t2.value)
    -> FROM
    -> (
    -> SELECT
    -> UNIX_TIMESTAMP(`date`) AS date
    -> ,SUM(value) AS value
    -> FROM some_data1
    -> GROUP BY date
    -> ORDER BY date
    -> )t1
    -> join
    -> (
    -> SELECT
    -> UNIX_TIMESTAMP(`date`) AS date
    -> ,SUM(value) AS value
    -> FROM some_data1
    -> GROUP BY date
    -> )t2
    -> ON t2.date >=t1.date-(1*24*3600) and t2.date<=t1.date
    -> GROUP BY 1
    -> ORDER BY 1
    ->
    -> ;
+---------------------+-------+---------------+
| date                | value | avg(t2.value) |
+---------------------+-------+---------------+
| 2014-03-03 00:00:00 |     6 |        6.0000 |
| 2014-03-04 00:00:00 |     6 |        6.0000 |
| 2014-03-05 00:00:00 |     5 |        5.5000 |
| 2014-03-06 00:00:00 |    12 |        8.5000 |
| 2014-03-07 00:00:00 |     5 |        8.5000 |
| 2014-03-08 00:00:00 |     5 |        5.0000 |
| 2014-03-09 00:00:00 |     5 |        5.0000 |
| 2014-03-10 00:00:00 |     5 |        5.0000 |
+---------------------+-------+---------------+
8 rows in set, 2 warnings (0.00 sec)

mysql> SELECT
    -> FROM_UNIXTIME(time)
    -> ,FLOOR((time-1388332800)/(7*24*3600)) as weekNum
    -> ,SUM(value) as _sum
    -> ,SUM(value)/7 as _sum_divide_7
    -> ,AVG(value) as _avg
    -> FROM
    -> (
    -> SELECT
    -> DISTINCT UNIX_TIMESTAMP(date) AS time
    -> ,SUM(value) AS value
    -> FROM some_data1
    -> GROUP BY time
    -> ) s
    -> GROUP BY weekNum;
+---------------------+---------+------+---------------+--------+
| FROM_UNIXTIME(time) | weekNum | _sum | _sum_divide_7 | _avg   |
+---------------------+---------+------+---------------+--------+
| 2014-03-03 00:00:00 |       9 |   44 |        6.2857 | 6.2857 |
| 2014-03-10 00:00:00 |      10 |    5 |        0.7143 | 5.0000 |
+---------------------+---------+------+---------------+--------+
2 rows in set (0.00 sec)
```



再来一段纯代码：
```python
select FROM_UNIXTIME(t1.x) as x, t1.nts, avg(t2.nts) as nts

INSERT INTO some_data1 (unique_id, date, value) VALUES
 ( 'a', '2014-03-03', 5),
 ( 'a', '2014-03-04', 5),
 ( 'a', '2014-03-05', 3),
 ( 'a', '2014-03-06', 9),
 ( 'a', '2014-03-07', 1),
 ( 'a', '2014-03-08', 1),
 ( 'a', '2014-03-09', 1),
 ( 'a', '2014-03-10', 1),
 ( 'b', '2014-03-03', 1),
 ( 'b', '2014-03-04', 1),
 ( 'b', '2014-03-05', 2),
 ( 'b', '2014-03-06', 3),
 ( 'b', '2014-03-07', 4),
 ( 'b', '2014-03-08', 4),
 ( 'b', '2014-03-09', 4),
 ( 'b', '2014-03-10', 4);

SELECT FROM_UNIXTIME(t1.date) AS date, t1.value , avg(t2.value)
FROM
(
	SELECT
	UNIX_TIMESTAMP(`date`) AS date
	,SUM(value) AS value
	FROM some_data1
	GROUP BY date
	ORDER BY date
)t1
join
(
	SELECT
	UNIX_TIMESTAMP(`date`) AS date
	,SUM(value) AS value
	FROM some_data1
	GROUP BY date
)t2
ON t2.date >=t1.date-(1*24*3600) and t2.date<=t1.date
GROUP BY 1
ORDER BY 1

SELECT
FROM_UNIXTIME(time)
,FLOOR((time-1388332800)/(7*24*3600)) as weekNum
,SUM(value) as _sum
,SUM(value)/7 as _sum_divide_7
,AVG(value) as _avg
FROM
(
	SELECT
	DISTINCT UNIX_TIMESTAMP(date) AS time
	,SUM(value) AS value
	FROM some_data1
	GROUP BY time
) s
GROUP BY weekNum;
```
* ON t2.date >=t1.date-(1\*24\*3600) and t2.date<=t1.date : 把这句的1\*24\*3600的1改为7，就是7日均。
* FLOOR((time-1388332800)/(7*24*3600)) as weekNum: 1388332800是一个开始日期，是2013-12-30，我选择最一天作为第一周（会计算得到0）。

