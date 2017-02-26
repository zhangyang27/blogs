翻译[iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns/tree/master/lazy-loading)的延迟加载模式

## Intent
Lazy loading is a design pattern commonly used to defer
initialization of an object until the point at which it is needed. It can
contribute to efficiency in the program's operation if properly and
appropriately used.

`延迟加载技术通常用于推迟一个对象的初始化操作直到这个对象真正被使用时。如果适当使用将有助于提供程序的运行效率。`

![alt text](https://github.com/iluwatar/java-design-patterns/raw/master/lazy-loading/etc/lazy-loading.png "Lazy Loading")

## Applicability
Use the Lazy Loading idiom when

* eager loading is expensive or the object to be loaded might not be needed at all
* `当对象初始化的成本很高或者当这个对象有可能完全不会被用到时。`

## Real world examples

* JPA annotations @OneToOne, @OneToMany, @ManyToOne, @ManyToMany and fetch = FetchType.LAZY

## Credits

* [J2EE Design Patterns](http://www.amazon.com/J2EE-Design-Patterns-William-Crawford/dp/0596004273/ref=sr_1_2)
