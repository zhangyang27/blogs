#### vue.js入门与表格实例

今天看了[vue.js入门基础](http://www.imooc.com/learn/694)的视频，比较有感触。觉得自己在前端开发的方式上面真的非常落后了。

[vue官网](http://cn.vuejs.org/)对vue的总结在两个词：
 * 响应的数据绑定: 典型双向绑定，model的修改会同步到view，view上的修改会立刻同步到model。在单向绑定中，model改变后插入到view中，view是不会影响到model的。[参考](https://segmentfault.com/q/1010000002511449/a-1020000002514653)
 * 组合的视图组件：主要是组件化，传统的方式计算一个元素一个元素的挨个排下来就好了，js、css都写在了一堆。但组件化后，vue将每一个元素涉及一段html、js、css写在一个vue的文件里。达到了高度复用。

除此之外，我的感受就是改变了写前端页面的方式，符合vue框架的代码更加利于理解和开发，比如页面的数据写在哪，普通方法写在哪，监听方法又写在哪。

##### 实践
下面通过完成一个例子来实践vue开发：
需求：
<script async src="//jsfiddle.net/chrisvfritz/50wL7mdz/embed/js,html,css,result/dark/"></script>


