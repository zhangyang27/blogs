#### 数据可视化调研

近几天了解了一下外界数据可视化的状况，发现自己之前真犹如井底之蛙。

从开源项目来说，我自己使用了下载使用了[saiku](https://github.com/OSBI/saiku)和[superset](https://github.com/airbnb/superset)。

* saiku界面比较传统老式，但是有些项目基于其二次开发，我也导入了数据，使用了一番，但缺乏对中文的支持。
* superset界面优美，社区活跃，感觉非常完美。
* [Cboard](https://github.com/yzhang921/CBoard):国人开发，虽然是中文但是功能差了很多很多(下载、表排序等等)，而且olap居然在前端完成，所以限制了从后端读入到前端的数据默认只有300000，这一点太麻烦了。
* [zeppelin](http://zeppelin-project.org/)：
* 其它的请[参考](https://github.com/yzhang921/CBoard/wiki/%E5%89%8D%E8%A8%80#%E9%A1%B9%E7%9B%AE%E8%83%8C%E6%99%AF)

可视化的后端就是数据源，我以后也可以对[kylin](http://kylin.apache.org/cn/)进行一定研究，kylin能完成数据的整合，建立多维立方体（cube），并提供REST url供可视化前端使用，kylin的再后端就是Hadoop。也就说Hadoop数据量太大时，查询缓慢，可以使用kylin预处理后，查询速度会极大提高，这样前端再从kylin获得数据即能完成交互式的可视化界面了。

参考链接：

* [saiku的官方文档](http://saiku-documentation.readthedocs.io/en/latest/index.html):感觉都没人维护了
* [向saiku添加数据源](http://www.bubuko.com/infodetail-1377183.html)
* [向saiku添加数据源并建立数据立方体](http://type-exit.org/adventures-with-open-source-bi/2010/07/creating-a-basic-mondrian-olap-cube/)
* [saiku二次开发和构建](http://www.cnblogs.com/NextNight/p/6520106.html)
* [kylin与其它BI的结合](http://www.chinahadoop.cn/course/825/learn#lesson/16399): 可以比较综合的了解这线。
* [kylin简介](http://www.tuicool.com/articles/Yjm6bq7)

