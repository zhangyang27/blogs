##### 用SQL完成推荐：推荐相似用户喜爱的物品

蛮惊喜，居然简单几句SQL就能完成。
这个简单的推荐策略是：先找出与目标用户最相似的用户，也就是喜欢的物品重复最多的用户，再推荐相似用户已经喜欢，但是目标用户还没有喜欢的物品。

这里是以用户存储书签为例子的，
来自 Addison.Wesley.PHP.and.MySQL.Web.Development.4th.2009.pdf 书籍中的
Chapter 27 Building User Authentication and Personalization:Implementing Recommendations。


```python
create table bookmark (
	username varchar(16) not null,
	bm_URL varchar(255) not null,
	index(username),
	index(bm_URL),
	primary key(username,bm_URL)
);

insert into bookmark values ('Bill','www.baidu.com');
insert into bookmark values ('Bill','www.sina.com.cn');
insert into bookmark values ('Bill','www.qq.com');
insert into bookmark values ('Bill','www.csdn.net');

insert into bookmark values ('Jack','www.baidu.com');
insert into bookmark values ('Jack','www.nuomi.cn');
insert into bookmark values ('Jack','www.qq.com');
insert into bookmark values ('Jack','www.csdn.net');
	
insert into bookmark values ('Liz','www.baidu.com');
insert into bookmark values ('Liz','map.baidu.cn');

insert into bookmark values ('Rose','news.baidu.com');
insert into bookmark values ('Rose','map.baidu.cn');

#书上原版，但是无法选出与目标用户有着相同url匹配最多的用户
#在本例中就是Jack
select 
bm_URL 
,count(bm_URL)
from bookmark
where username in 
(
	select
	distinct (b2.username) 
	from bookmark b1,bookmark b2
	where 
	b1.username = 'Bill'
	and b1.username != b2.username
	and b1.bm_URL = b2.bm_URL
) and bm_URL not in 
(	
	select 
	bm_URL
	from bookmark
	where username = 'Bill'
) group by bm_URL
/* output:

bm_URL	count(bm_URL)
map.baidu.cn	1
www.nuomi.cn	1

*/


#下面是我的改写，能够把最相似的一名用户挑选出来
select
b2.username
from bookmark b1,bookmark b2
where 
b1.username = 'Bill'
and b1.username != b2.username
and b1.bm_URL = b2.bm_URL
group by b2.username 
order by count(b2.username) desc limit 1
/* output：

username
Jack

*/


#再下面是改写一下where中的in
select
a.username
,a.bm_URL
,count(a.bm_URL)
from
bookmark a
inner join
(
	select
	b2.username as username
	from bookmark b1,bookmark b2
	where
	b1.username = 'Bill'
	and b1.username != b2.username
	and b1.bm_URL = b2.bm_URL
	group by b2.username
	order by count(b2.username) desc limit 1
) b on a.username = b.username
left join
(
	select
    bm_URL
	from bookmark
	where
	username = 'Bill'
)c on c.bm_URL=a.bm_URL where c.bm_URL is Null
/* output:

username	bm_URL	count(a.bm_URL)
Jack	www.nuomi.cn	1

*/

```
