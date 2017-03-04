### vue.js入门与表格实例

今天看了[vue.js入门基础](http://www.imooc.com/learn/694)的视频，比较有感触。觉得自己在前端开发的方式上面真的非常落后了。

[vue官网](http://cn.vuejs.org/)对vue的总结在两个词：
 * 响应的数据绑定: 典型双向绑定，model的修改会同步到view，view上的修改会立刻同步到model。在单向绑定中，model改变后插入到view中，view是不会影响到model的。[参考](https://segmentfault.com/q/1010000002511449/a-1020000002514653)
 * 组合的视图组件：主要是组件化，传统的方式计算一个元素一个元素的挨个排下来就好了，js、css都写在了一堆。但组件化后，vue将每一个元素涉及一段html、js、css写在一个vue的文件里。达到了高度复用。

除此之外，我的感受就是改变了写前端页面的方式，符合vue框架的代码更加利于理解和开发，比如页面的数据写在哪，普通方法写在哪，监听方法又写在哪。

#### 实践
下面通过完成一个例子来实践vue开发：
需求：根据数据产出表格，并能判断是否有两个表头和按数据需要合并第一个表头。
```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>learning_vuejs</title>
	<script src="https://cdn.bootcss.com/vue/2.2.1/vue.js"></script>
  </head>
  <body>
	<div id="app" >
		<table border="1">
			<thead>
				<tr>
					<th v-if="isTwoCol" v-for="c in extraCol" :colspan="c.colspan">{{ c.title }}</th>
				</tr>
				<tr>
					<th v-for="c in columns">{{ c }}</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="entry in tableData">
					  <td v-for="key in columns">
						{{entry[key]}}
					  </td>
				</tr>
			</tbody>
		</table>
	</div>
	<script>
		new Vue({
		  el: '#app',
		  data: {
			isTwoCol:true,
			extraCol:[
				{title:"merge2",colspan:2},
				{title:"merge1",colspan:1},
			],
			columns:['id','name','age'],
			tableData: [
				  {id:1, name:"John",age:"20"},
				  {id:2, name:"Jane",age:"24"},
				  {id:3, name:"Susan",age:"16"},
				  {id:4, name:"Chris",age:"55"},
				  {id:5, name:"Dan",age:"40"}
			]
		  }
		})
    </script>
  </body>
</html>
```
* [code](begin_learning_vue.html)


