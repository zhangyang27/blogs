##### 特别的SQL语句


1. leetcode的题：Combine Two Tables 涉及left join, 有三种写法，效果一样
	* SELECT p.FirstName, p.LastName, a.City, a.State FROM Person p LEFT OUTER JOIN Address a USING (PersonId);
	* SELECT FirstName, LastName, City, State FROM Person p LEFT JOIN Address a on p.PersonId = a.PersonId
	* [学习链接](https://www.oschina.net/question/12_60726)
	
