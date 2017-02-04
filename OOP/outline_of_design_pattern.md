### 所有设计模式的要点

#### 创建性模式:

#### 结构型模式:
##### 组合
* 定义：组合多个对象形成树形结构以表示具有"整体-部分"关系的层次结构。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/5/5a/Composite_UML_class_diagram_%28fixed%29.svg)" width="50%" height="50%">
* 场景：面对树形结构（指不同元素和容器的结构，容器可以包含容器，也可以包含元素）时可采用的模式，比如不同文件与文件夹、GUI中不同的样式与容器、应用程序的菜单栏。
* 例子：杀毒软件即能对文件杀毒，又能文件夹杀毒，对文件夹杀毒时，会递归杀掉里面的所有文件和文件夹，这时就有一个树形结构需要被处理。
* [code](java_design_pattern_code/src/composite)
* 优点：对树形结构的有效控制，方便新增。

##### 装饰
* 定义：动态地给一个对象增加一些额外的职责，就增加对象功能来说，装饰模式比生成子类实现更灵活。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/e/e9/Decorator_UML_class_diagram.svg" width="50%" height="50%">
* 场景：不影响其它对象，以动态、透明的方式给单个对象添加职责。当采用继承不利于系统扩展时（导致子类过多或被定义为final的类），采用装饰模式。
* 例子：给汉堡加调理，不影响汉堡被吃的功能，还能使得味道更好；给毛坯房装修，不影响毛坯房居住的功能，能使居住条件更好；GUI应用中窗口增加滚动条；
* [code](java_design_pattern_code/src/decorator)
* 优点：灵活扩展类的功能；多次装饰；具体构件类和装饰类独立变化，互不影响；
* 缺点：排错难。

#### 行为型模式:
##### 参考
1. 设计模式的艺术软件开发人员内功修炼之道_刘伟
2. wikipedia
