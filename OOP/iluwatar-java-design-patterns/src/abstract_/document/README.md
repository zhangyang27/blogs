翻译[iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns/tree/master/abstract-document)的抽象文档模式

## Intent

Achieve flexibility of untyped languages and keep the type-safety 

`即能得到无类型语言的灵活性，又能保证类型安全。`

这里所谓无类型语言的灵活性，我想最重要的应该就是程序运行时动态添加新的属性了。



![alt text](https://github.com/iluwatar/java-design-patterns/raw/master/abstract-document/etc/abstract-document-base.png "Abstract Document Base")

![alt text](https://github.com/iluwatar/java-design-patterns/raw/master/abstract-document/etc/abstract-document.png  "Abstract Document Traits and Domain")

写完代码后的感受：

例子围绕着汽车对象和其部件展开。汽车的部件不胜枚举，如果真的要在汽车类里将所有的部件作为属性全部列举出来，几乎是不可能的。所以可以使用HashMap的键值对来保存属性。

如果仅仅是为了能够得到动态添加新属性，那这也就够了，但是又为了保证类型安全，才有了抽象文档模式。

该设计模式利用特性(trait)这个概念来约束了汽车的部件的属性和汽车，保证了类型安全。

例子中有两个实体(作为类)，四个特性(作为接口)，属性则可以是特性(价格特性)或者是由特性组成的实体(部件)，而特性的类型又被限制了，从而保证了属性的类型安全。所需属性(作为部件)在程序运行中动态添加，从而达到了灵活性。

* 汽车实体：拥有部件特性、型号特性、价格特性：后两个特性就限制了汽车的两个属性的类型。比如型号的类型是String，价格的特性是Number。
* 部件实体：拥有类型特性、型号特性、价格特性：每个一部件受到了特性的限制，比如型号的类型是String，价格的特性是Number。

举例来说，汽车有个部件是车轮，车轮作为部件就会有三个属性：类型特性、型号特性、价格特性，并且受到了这三个特性的类型限制。

特性到底是如何限制属性类型的呢？

对一个部件而言，能添加键值对已经被限制了(类型、型号、价格)，键已由特性接口预定义了，值也通过强制类型转换限制了。如果取值时通过不了强制转换，就直接报错。 

最后注意，这个设计模式中汽车类里没有写车轮这个属性，是运行时动态添加的。

代码的细节难度还是很高的...呼...加油哈


## Applicability
Use the Abstract Document Pattern when

* there is a need to add new properties on the fly
* you want a flexible way to organize domain in tree like structure
* you want more loosely coupled system

`下列情况可以考虑使用抽象文档模式`

* `程序运行时需要添加新的属性`
* `当希望以一种较为灵活的方式组织树形结构的各个节点时`：从代码的角度来看，汽车实现和部件实体确实是树形结构，并且确实比较灵活。
* `希望创建一个松耦合的系统`



## Credits

* [Wikipedia: Abstract Document Pattern](https://en.wikipedia.org/wiki/Abstract_Document_Pattern):由wiki参考文献来看，这还是一个比较新的设计模式。
* [Martin Fowler: Dealing with properties](http://martinfowler.com/apsupp/properties.pdf)
