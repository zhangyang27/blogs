### 所有设计模式的要点

#### 创建性模式
* 关注对象的创建。
* 将对象的创建和使用分离；创建对象通常比较复杂，将创建的过程统一起来，避免出错。
* 降低耦合；使用对象不需要关注如何创建对象，从而降低耦合。

#### 结构型模式
* 关注如何组织类与对象，形成某种结构。

##### 组合
* 定义：组合多个对象形成树形结构以表示具有"整体-部分"关系的层次结构。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/5/5a/Composite_UML_class_diagram_%28fixed%29.svg" width="50%" height="50%">
* 场景：面对树形结构（指不同元素和容器的结构，容器可以包含容器，也可以包含元素）时可采用的模式，比如不同文件与文件夹、GUI中不同的样式与容器、应用程序的菜单栏。
* 例子：杀毒软件即能对文件杀毒，又能文件夹杀毒，对文件夹杀毒时，会递归杀掉里面的所有文件和文件夹，这时就有一个树形结构需要被处理。
* [code](java_design_pattern_code/src/composite)
* 优点：对树形结构的有效控制，方便新增。

##### 装饰
* 定义：动态地给一个对象增加一些额外的职责，就增加对象功能来说，装饰模式比生成子类实现更灵活。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/e/e9/Decorator_UML_class_diagram.svg" width="50%" height="50%">
* 场景：不影响其它对象，以动态、透明的方式给单个对象添加职责。当采用继承不利于系统扩展时（导致子类过多或被定义为final的类），采用装饰模式。
* 例子：给汉堡加调理，不影响汉堡被吃的功能，还能使得味道更好；给毛坯房装修，不影响毛坯房居住的功能，能使居住条件更好；GUI应用中窗口增加滚动条；某个函数需要插入日志、性能测试；
* [code](java_design_pattern_code/src/decorator)
* 优点：灵活扩展类的功能；多次装饰；具体构件类和装饰类独立变化，互不影响；
* 缺点：排错难。

##### 外观
* 定义：外部与一个子系统的通信痛过一个统一的外观角色进行，为子系统中的一组接口提供一个一致的入口，外观模式定义了一个高层接口，这个接口使得这个子系统更加易用。
* 图：<img src="https://upload.wikimedia.org/wikipedia/en/5/57/Example_of_Facade_design_pattern_in_UML.png" width="50%" height="50%">
* 场景：多个业务类通常作为整体出现时，客户类不逐一与业务类通信协作，而只与引入的一个外观类通信协作，由外观类负责与多个业务类通信协作；作为复杂（子）系统的入口出现；层次化结构中，每层都有一个外观类，降低层与层之间的耦合。
* 例子：为了吃饭，我可做饭（买菜、切菜、煮饭、炒菜...），但我也可以到餐馆吃饭，餐馆直接提供了可以吃的饭菜，可以认为餐馆就是外观类。
* [code](java_design_pattern_code/src/facade)
* 优点：客户端与子系统解耦；子系统的变化不会影响到客户端；多个客户端都可调用外观类（即可获得复杂子系统的功能）；
* 缺点：实际上很难限制客户端直接使用子系统；

##### 享元
* 定义：运用共享技术有效地支持大量细粒度对象的复用。
* 图：<img src="https://github.com/zhangyang27/blogs/raw/master/images/flyweight_pattern.png" width="50%" height="50%">
* 场景：系统需要大量使用相同或相似对象时，利用享元模式可以实现对象的多次复用。将变化的部分作为外部状态，不变的部分作为内部状态。以字符串为例，每个字符的内容是不变的，但是字符的位置是变化的。
* 例子：[java.lang.Integer.valueOf](http://stackoverflow.com/questions/6521067/why-is-java-lang-integer-valueof-a-flyweight-pattern)；实际上我觉得享元模式大量使用，比如字符串(符合定义中的细粒度)、线程池、数据库连接池，都有享元的思想。
* [code](java_design_pattern_code/src/flyweight)
* 优点：节约内存。
* 缺点：使用系统复杂；需要准确区分对象的内部和外部状态。

##### 代理
* 定义：给某个对象提供一个代理，并由代理控制对该对象的访问。(Provide a surrogate or placeholder for another object to control access to it.)
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Proxy_pattern_diagram.svg/800px-Proxy_pattern_diagram.svg.png" width="50%" height="50%">
* 场景：为了远程调用的代理、为了缓存的代理、为了保护（权限）的代理、为了额外的操作（比如计数器）的代理、为了创建耗时对象的代理（延迟初始化）。
* 例子：代购、翻译、分布式系统的远程API调用、代理服务器、反向代理服务器
* [code](java_design_pattern_code/src/proxy)
* 优点：客户端针对抽象编程，方便更换代理；远程代理可以将耗费资源的操作移到性能更好的服务器上，提高整体效率；
* 缺点：有了代理速度变慢；代理类的实现可能异常复杂：比如远程代理。
* 与装饰模式的区别：代理模式增加全新的功能、装饰模式增加相关功能；代理模式还控制了对代理对象的访问，而装饰只是对对象加功能。

#### 行为型模式
* 关注对象之间的交互、通信、协作，明确对象的职责。
* （我现在看来好深奥 2017-02-04 17:49:07 ）

##### 职责链
* 定义：避免请求者与接收者耦合；让多个有机会接受请求的对象组成链条，沿着链条传送请求，直到有对象处理它为止。
* 图：<img src="https://github.com/zhangyang27/blogs/raw/master/images/chain.png" width="50%" height="50%">
* 场景：多个对象可以处理同一请求时可以应用职责链模式；需要动态组合一组对象来处理请求时可以使用职责链模式。
* 例子：斗地主出牌时（一个一个确认出牌）；请假、报销的审批过程（领导无法批准的则由更高级的领导审批）；Web应用对请求的过滤器；
* [code](java_design_pattern_code/src/chain)
* 优点：职责链更为灵活，能够动态的增加或者修改职责链上的对象；
t 缺点：职责链过长时响应慢、调试难、性能差；建链不当，会死循环；配置错误的话，请求可能不被任何处理对象处理；

##### 参考
1. 设计模式的艺术软件开发人员内功修炼之道_刘伟
2. wikipedia
