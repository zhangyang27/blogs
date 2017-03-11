#### saiku 二次开发构建

目的就是下载saiku源码，然后自己构建一遍，为以后二次开发作准备。发个图纪念一下。
<img src="https://github.com/zhangyang27/blogs/raw/master/images/saiku_sfjdl.png" width="40%" height="40%">

辛辛苦苦折腾了几天，终于搞清楚了来龙去脉。

流程如下：
1. 从git clone获得源码：[saiku](https://github.com/OSBI/saiku)
1. 以 已存在的maven项目方式 导入到eclipse。
1. 使用mvn clean package -Dmaven.test.skip=trur的方式执行：可能非常慢，要下载很多jar包。
1. 在saiku-server里面的target/dist执行启动即可。

总结如下：
1. 要熟悉[maven](http://www.imooc.com/learn/443): 这是java的项目管理工具
1. 不要太相信国人写的一些教程，首先是不规范，其次信息过期。
	* 不规范是指既然saiku已经开源了，肯定有一定的加入的方式。不用自己把文件拷过来拷过去的构建一个web项目。
	* 信息过期主要是因为我按国人的教程使用旧版本，结果旧版本在官方依赖的库已经删了，只有最新版的依赖。按正规流程是pom.xml去下载，不用我一个一个找。
1. 仔细看清log，对症下药。 


TO LIST：
1. 为什么最后项目构建到saiku-server里面了。
1. 去掉需要上传
1. 支持数据源中的中文。
