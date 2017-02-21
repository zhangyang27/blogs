## 所有设计模式的要点

### 创建性模式
* 关注对象的创建。
* 将对象的创建和使用分离；创建对象通常比较复杂，将创建的过程统一起来，避免出错。
* 降低耦合；使用对象不需要关注如何创建对象，从而降低耦合。

#### 单例
* 定义：确保一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，
* 要点：
	* 饿汉式单例类（Eager Singleton）:将唯一实例设置为静态变量；类加载时自动实例化，不用考虑多线程访问的问题。但是无论是否使用这个单例类都要创建，从资源利用效率上来讲不好。
	* 懒汉式单例类（Lazy Singleton）:使用延迟加载技术，不自动实例化，需要时才创建。但必须处理多线程访问的问题。所以必须使用双重检查锁定等机制(判断两次instance == null)来控制。
	* Java可以使用IoDH(Initialization on Demand Holder)技术，也就是使用静态内部类完成单例类的创建，即能延迟创建、又能保证线程安全。
* 图：<img src="https://github.com/zhangyang27/blogs/raw/master/images/singleton_uml_gjj.png" width="50%" height="50%">
* 场景：系统只需要一个实例对象（比如序列号生成器、资源管理器或者资源太大而只能有一个对象）
* 例子：Windows任务管理器；负载均衡器；数据库连接池；[java.lang.Runtime#getRuntime()](http://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html#getRuntime%28%29); [java.awt.Desktop#getDesktop()](http://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html#getDesktop--); [java.lang.System#getSecurityManager()](http://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getSecurityManager--)
* [code](java_design_pattern_code/src/singleton)
* 优点：因为内存中只有一个对象，节约了资源，提高了性能；可以依据需求创建可变数目的实例（多例类）；
* 缺点：没有抽象层，扩展困难；单例类责任过重，又负责创建，又负责提供业务方法；面向对象的语言都提供了垃圾回收技术，如果唯一实例长期不被使用而又被回收了的话，下次调用又将重新实例化，但之前单例对象的状态会丢失。

### 结构型模式
* 关注如何组织类与对象，形成某种结构。

#### 组合
* 定义：组合多个对象形成树形结构以表示具有"整体-部分"关系的层次结构。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/5/5a/Composite_UML_class_diagram_%28fixed%29.svg" width="50%" height="50%">
* 场景：面对树形结构（指不同元素和容器的结构，容器可以包含容器，也可以包含元素）时可采用的模式，比如不同文件与文件夹、GUI中不同的样式与容器、应用程序的菜单栏。
* 例子：杀毒软件即能对文件杀毒，又能文件夹杀毒，对文件夹杀毒时，会递归杀掉里面的所有文件和文件夹，这时就有一个树形结构需要被处理。
* [code](java_design_pattern_code/src/composite)
* 优点：对树形结构的有效控制，方便新增。

#### 装饰
* 定义：动态地给一个对象增加一些额外的职责，就增加对象功能来说，装饰模式比生成子类实现更灵活。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/e/e9/Decorator_UML_class_diagram.svg" width="50%" height="50%">
* 场景：不影响其它对象，以动态、透明的方式给单个对象添加职责。当采用继承不利于系统扩展时（导致子类过多或被定义为final的类），采用装饰模式。
* 例子：给汉堡加调理，不影响汉堡被吃的功能，还能使得味道更好；给毛坯房装修，不影响毛坯房居住的功能，能使居住条件更好；GUI应用中窗口增加滚动条；某个函数需要插入日志、性能测试；
* [code](java_design_pattern_code/src/decorator)
* 优点：灵活扩展类的功能；多次装饰；具体构件类和装饰类独立变化，互不影响；
* 缺点：排错难。

#### 外观
* 定义：外部与一个子系统的通信通过一个统一的外观角色进行，为子系统中的一组接口提供一个一致的入口，外观模式定义了一个高层接口，这个接口使得这个子系统更加易用。
* 图：<img src="https://upload.wikimedia.org/wikipedia/en/5/57/Example_of_Facade_design_pattern_in_UML.png" width="50%" height="50%">
* 场景：多个业务类通常作为整体出现时，客户类不逐一与业务类通信协作，而只与引入的一个外观类通信协作，由外观类负责与多个业务类通信协作；作为复杂（子）系统的入口出现；层次化结构中，每层都有一个外观类，降低层与层之间的耦合。
* 例子：为了吃饭，我可做饭（买菜、切菜、煮饭、炒菜...），但我也可以到餐馆吃饭，餐馆直接提供了可以吃的饭菜，可以认为餐馆就是外观类。
* [code](java_design_pattern_code/src/facade)
* 优点：客户端与子系统解耦；子系统的变化不会影响到客户端；多个客户端都可调用外观类（即可获得复杂子系统的功能）；
* 缺点：实际上很难限制客户端直接使用子系统；

#### 享元
* 定义：运用共享技术有效地支持大量细粒度对象的复用。
* 图：<img src="https://github.com/zhangyang27/blogs/raw/master/images/flyweight_pattern.png" width="50%" height="50%">
* 场景：系统需要大量使用相同或相似对象时，利用享元模式可以实现对象的多次复用。将变化的部分作为外部状态，不变的部分作为内部状态。以字符串为例，每个字符的内容是不变的，但是字符的位置是变化的。
* 例子：[java.lang.Integer.valueOf](http://stackoverflow.com/questions/6521067/why-is-java-lang-integer-valueof-a-flyweight-pattern)；实际上我觉得享元模式大量使用，比如字符串(符合定义中的细粒度)、线程池、数据库连接池，都有享元的思想。
* [code](java_design_pattern_code/src/flyweight)
* 优点：节约内存。
* 缺点：使用系统复杂；需要准确区分对象的内部和外部状态。

#### 代理
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

#### 职责链
* 定义：避免请求者与接收者耦合；让多个有机会接受请求的对象组成链条，沿着链条传送请求，直到有对象处理它为止。
* 图：<img src="https://github.com/zhangyang27/blogs/raw/master/images/chain.png" width="50%" height="50%">
* 场景：多个对象可以处理同一请求时可以应用职责链模式；需要动态组合一组对象来处理请求时可以使用职责链模式。
* 例子：斗地主出牌时（一个一个确认出牌）；请假、报销的审批过程（领导无法批准的则由更高级的领导审批）；Web应用对请求的过滤器；
* [code](java_design_pattern_code/src/chain)
* 优点：职责链更为灵活，能够动态的增加或者修改职责链上的对象；
* 缺点：职责链过长时响应慢、调试难、性能差；建链不当，会死循环；配置错误的话，请求可能不被任何处理对象处理；

#### 命令
* 定义：将请求封装成对象，客户端可以使用注入参数的方式 ( setCommand ) 指定不同的请求(即命令)。方便实现请求排队、请求日志，方便地支持了备份和撤销功能。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/b/bf/Command_pattern.svg" width="50%" height="50%">
* 场景：请求发送者和接收者解耦；请求发送者和请求（命令）可以用不同的生命周期，发送者不在了，命令依然存在；需要请求（命令）队列要调用多个接收者；系统需要支持（请求）命令的撤销或者恢复，在网站部署、数据库备份方面我觉得很有意义；需要与组合模式一起形成命令的树形结构（称为宏命令）
* 例子：开关连着电线，电线连着电灯，电线也可以连着排气扇；电线就是命令，换电器只需要换线即可；不同的按钮有着不同的功能，按钮的功能可以随意切换，就是因为将按钮的请求单独封装成了对象，从而使用了对象模式。

	<img src="https://github.com/zhangyang27/blogs/raw/master/images/command_pattern.png" width="20%" height="20%">

* [code](java_design_pattern_code/src/command_pattern)
* 优点：降低系统耦合度；容易增加新的命令；方便设计命令队列和宏命令（组合命令）；为命令的撤销和恢复提供了一种实现方案。
* 缺点：类多，每一个命令都需要一个类，导致系统变得复杂。


#### 解释器
* 定义：定义一个语言的文法，并建立一个解释器来解释该语言的句子，这里的"语言"是指使用规定格式和语法的代码。
* 补充：
	* 为了理解解释器，需要补充一些文法规则的知识，通常一种语言都会有终结符和非终结符。终结符不可分割，而非终结符由若干个终结符来组成。如"1+2+3-4+1"，其语法规则如下：
	* `expression ::= value | operation`
	* `operation ::= expression '+' expression | expression '-' expression`
	* `value ::= an integer`
* UML图	
	* <img src="https://upload.wikimedia.org/wikipedia/commons/b/bc/Interpreter_UML_class_diagram.svg" width="50%" height="50%">
	* TerminalExpression实现了对文法中终结符的解释；NonterminalExpression实现了对非终结表达符的解释，其可能再包含非终结表达符，所以一般由递归完成。Context环境类保存一些额外的全局信息和公共方法。
	* 每一个终结符或者非终结符都会有一个类与之对应。
* 场景：某些情况下，为了能够更好的描述某些特定(重复)的问题，可以创建一种新的语言，这些语言拥有自己的表达式和结构，即文法规则，这些问题的实例将对应为语言的句子，这里可以用解释器模型来设计新的语言。但注意文法规则不能太复杂，并且对执行效率要求不高。
* 例子：正则表达式；XML文档解释领域；SQL语句；对于解释字符串"1+3+1-4"（注意这是字符串，如果作为数值表达式的话，编程语言可以直接识别)，如果编程语言是面向对象的，那么我们可以利用解释器模式写一套规则来解释"1+3+1-4"，完成计算。
* [code](java_design_pattern_code/src/Interpreter)
* 优点：因为每个文法规则都用单独的一个类来表示，易于改变和扩展文法，比如增加新的解释表达式。我觉得这个模式将解释器的问题描述的特别清楚，代码怎么写，写在哪都有章可循。
* 缺点：文法复杂的情况下，规则多，类就多，难以管理和维护。因为由大量的循环和递归调用，所以执行效率低。


#### 迭代器
* 定义：提供一种方法来访问数据聚合对象，而不用暴露这个对象的内部表示（我认为是属性），别名为游标。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/1/13/Iterator_UML_class_diagram.svg" width="50%" height="50%">
* 场景：访问聚合对象的内容时无需暴露它的内部实现，客户端不需要知道内部实现细节；当需要为一个聚合对象提供多种遍历方式时可以采用迭代器模式；可以为不同的聚合结构提供一个统一的访问接口，但是接口的实现类可以按需提供不同的遍历方式。
* 例子：电视机是一个频道容器，遥控器实现了对电视机内频道的遍历。java的List和Set都实现了Collection接口，而Collection接口又实现了Iterable接口，所以实现了Collection接口的都实现了迭代器。
* [code](java_design_pattern_code/src/iterator)
* 优点：支持以不同的方式遍历对象，需要新的遍历方式时只需添加一个迭代器的实现类。简化了聚合类。引入了抽象层，增加聚合类和迭代器类都非常方便。
* 缺点：存储数据和遍历数据的职责分离，类的个数成对增加。抽象类的设计难度大，就像刚开始Iterator没有考虑到逆向遍历。

#### 中介者
* 定义：用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。又称调停者模式。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/e/e4/Mediator_design_pattern.png" width="50%" height="50%">
* 场景： 对象之间的引用关系复杂；一个对象由于引用了其它多个对象并直接通信，导致难以复用时可以使用中介者模式；
* 图：<img src="https://github.com/zhangyang27/blogs/raw/master/images/mediator_pattern1_asldjf.png" width="50%" height="50%">
* 例子：QQ群，群作为一个中介者，传递了一个用户对其它所有用户说的话，而不需要用户逐一告诉每个用户。在GUI控件库中比较多，比如点了这按钮，另一个列表也会变的情况。All scheduleXXX() methods of [java.util.Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)；[java.util.concurrent.Executor#execute()](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executor.html#execute-java.lang.Runnable-)；submit() and invokeXXX() methods of [java.util.concurrent.ExecutorService](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html); scheduleXXX() methods of [java.util.concurrent.ScheduledExecutorService](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledExecutorService.html); [java.lang.reflect.Method#invoke()](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html#invoke-java.lang.Object-java.lang.Object...-) 
* [code](java_design_pattern_code/src/mediator)
* 优点：简化了对象间的交互，使得对象之间的关系更易理解，将同事间多对多的关系转化为了一对的关系（星型结构）。增加新的中介者（新的交互方式）和新的同事都非常方便；使得同事类可以重用。
* 缺点：中介者类中包含大量同事交互细节，导致具体中介者类非常复杂，难以维护。
* 点评：怎么我感觉就是挪了一下代码的位置了，本来要写在每一个同事类里的代码，都转移到中介类里了，但确实是免去了同事类之间的引用。

#### 备忘录
* 定义：在不破坏封装的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样可以在以后将对象恢复到原先保存的状态。
* UML图：
	* Originator类其内部状态需要被储存或者利用备忘录储存的状态恢复；Memento类是Originator的备份模板（里面的属性将参考Originator类，可能是所有属性、也可能是部分属性），生成一个对象表示一次备份；Caretaker用于保存备忘录。
	* <img src="https://github.com/zhangyang27/blogs/raw/master/images/memento_pattern_gjj.png" width="50%" height="50%">
* 场景：当业务需要倒退(撤销)到某一个历史状态时，如下图，使用此模式。防止外界对象破坏对一个对象的历史状态的封装性。
* 图：<img src="https://github.com/zhangyang27/blogs/raw/master/images/memento_pattern_saf.png" width="50%" height="50%">
* 例子：棋类的悔棋。[java.util.Date](http://docs.oracle.com/javase/8/docs/api/java/util/Date.html)
* [code](java_design_pattern_code/src/Memento)
* 优点：提供了一种状态恢复的实现机制；备忘录实现了对信息的封装，一个备忘录对象是一种原发器对象状态的表示，不会被其它代码改动。 
* 缺点：耗费资源，如果原发器类的成员变量太多，多次保存就需要占用大量内存。
* 难点：如何实现多次撤销？如果在多次撤销过程中发生了分支该如何处理？

#### 观察者
* 定义：定义对象之间的一种一对多依赖关系，使得每当一个对象状态发生变化时，其相关依赖对象皆能得到通知并自动更新。观察者模式的别名有发布-订阅 (Publish/Subscribe)模式、模型-视图(Model/View)模式，源-监听(Source/Listener)模式或从属者(Dependents)模式。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Observer.svg/854px-Observer.svg.png" width="50%" height="50%">
* 场景：一个对象的状态行为发生变化将导致其它对象的状态或者行为发生变化；需要触发链时，A对象的行为影响了B对象，B对象的行为影响了C对象时，也可以用观察者模式来创建。
* 例子：红灯停，绿灯走中，信号灯是观察目标，汽车是观察者。MVC架构应用了观察者模式；[java.util.Observer](http://docs.oracle.com/javase/8/docs/api/java/util/Observer.html)；[java.util.EventListener](http://docs.oracle.com/javase/8/docs/api/java/util/EventListener.html)；[javax.servlet.http.HttpSessionBindingListener](http://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSessionBindingListener.html)
* [code](java_design_pattern_code/src/Observer)
* 优点：表示层和数据层的分离，定义了稳定的消息更新机制；观察者模式支持广播通信，观察目标会向所有已经注册的观察者发送通知；符合开闭原则，增加新的观察者无需要修改原有系统代码。
* 缺点：如果一个观察目标的观察者太多，通知所有观察者将花费不少时间。如果观察者和观察目标之间有循环依赖，那么会造成死循环。
* 要点：JDK有Observable类和Observer接口对观察者模式提供了支持。

#### 状态
* 定义：允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/e/e8/State_Design_Pattern_UML_Class_Diagram.svg" width="50%" height="50%">
	* 注意环境类（context）拥有状态对象，状态的切换有可能在环境类里发生，也有可能在具体状态类的业务代码中判断环境类的属性来切换状态。
	* 理解环境类的存在，可以用一个例子：一个银行帐号有多个状态（透支、正常），银行帐号就是环境类，而不同的状态会形成状态类，银行帐号拥有状态类，银行帐号拥有属性余额，状态类会在业务代码里根据余额来切换状态。
* 场景：当系统中某个对象存在多个状态，这些状态可以相互转换，并且对象在不同状态下行为不相同时可以使用状态模式。对象的行为依赖它的状态（比如某个属性），状态的改变将导致行为的改变；当代码中包含大量与对象状态有关的条件语句时，导致代码可维护性差，不能方便的增加或者删除，可以考虑状态模式。
* 例子：水(冰、水蒸气)有不同的状态，状态之间能转换；信用卡可能存在透支、正常状态；游戏角色的升级；
* [code](java_design_pattern_code/src/State)
* 优点：封装了状态转换的规则（封装到环境类和具体的状态类的某个方法中），对状态切换进行了统一的管理。将与状态有关的行为放在一个类中，切换状态类就可以使环境类拥有不同的行为。可以使多个环境对象共享一个状态对象（使用static关键字）。
* 缺点：增加类的个数，加大系统开销。状态类的设计和实现比较复杂；对开闭原则支持不好，增加了新的状态后，都需要修改代码完成状态的转换。

#### 策略
* 定义：定义一系列算法类，将每个算法封装起来，并让他们可以互相替换。策略模式让算法独立于使用它的客户而变化。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/3/39/Strategy_Pattern_in_UML.png" width="50%" height="50%">
* 场景：当系统需要动态地在几个算法里选择一种执行；不希望客户端知道复杂的、与算法相关的数据结构，可以在策略类里封装数据结构和算法。
* 例子：电影票根据用户的不同打折方式；Java SE的容器布局管理；
* [code](java_design_pattern_code/src/strategy)
* 优点：选择算法和新增算法时的灵活；提供了管理算法的办法（比如确保了每个算法的输入输出格式类似、便于验证等）；方便复用算法（算法单独封装在了类里）；
* 缺点：只适用于客户端知道该使用哪个算法时；类会变多；不支持一个策略类完成某些功能再交个另一个策略类处理。

#### 模板
* 定义：定义一个操作中的算法框架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些步骤。
* 图：<img src="https://upload.wikimedia.org/wikipedia/commons/5/52/Template_Method_UML.svg" width="50%" height="50%">
* 场景：将复杂的算法分割，将算法中固定不变的部分设计为模板方法和父类的具体方法，需要改变的地方由子类实现。也可实现子类对父类的反向控制（子类重新赋值isPaint决定Paint是否执行）。
* 例子：餐馆吃饭，点菜->吃->买单，点菜和买单步骤变化不大，吃的步骤变化多端。
* [code](java_design_pattern_code/src/template_method)
* 优点：子类的某些算法的实现不会算法的执行次序；代码复用技术；可以由子类实现反向控制；不同子类实现的方法不同，方便扩展和修改。
* 缺点：每个实现都需要一个子类，可能会导致类太多，系统越发庞大。

#### 访问者
* 定义：提供一个作用于某对象结构中的各个元素的操作表示，它使得可以在不改变元素的类的前提下定义作用于这些元素的新操作。
* 通俗的理解：访问者模式包含访问者和被访者两部分，被访者是一个含有各种元素的集合对象，而不同的访问者对被访者内的元素操作个不相同。定义的确晦涩难懂，但仔细思考后又觉得其更为准确。
* 图：<img src="https://upload.wikimedia.org/wikipedia/en/e/eb/Visitor_design_pattern.svg" width="50%" height="50%">
* 场景：系统中存在一个复杂对象结构，且不同的访问者对其所采取的操作各不相同时，可以考虑使用访问者模式。对象结构中对象对应的类（元素的种类）应当很少改变，但是对对象结构增加新操作时则非常的方便。
* 例子：XML文档解析、编译器的设计、复杂集合对象的处理；医生的处方单被不同的部门处理，如药房和收费处，都是对同一对象结构的不同访问。
* [code](java_design_pattern_code/src/visitor)
* 优点：增加新的访问者会非常方便；访问行为分散到各个访问者中，便于管理、分析。
* 缺点：增加新元素类会非常困难。

#### 参考
1. 设计模式的艺术软件开发人员内功修炼之道_刘伟
2. wikipedia
1. github开源项目：[java-design-patterns](https://github.com/iluwatar/java-design-patterns)
