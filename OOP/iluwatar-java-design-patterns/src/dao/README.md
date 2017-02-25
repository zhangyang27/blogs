翻译[iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns/tree/master/dao)的DAO模式

## Intent
Object provides an abstract interface to some type of database or
other persistence mechanism.

`对不同类型的数据库或者是别的持久化方案提供抽象接口的对象`

补充:

1. DAO是一个对象，就是Data Access Object，是用于数据访问的对象，这个对象只提供接口，而具体的实现由子类完成。
1. 不一定是持久化方案吧？示例代码里面也有内存。当然可能内存后面还跟了一个持久化方案，所以也算是吧。

![alt text](https://github.com/iluwatar/java-design-patterns/raw/master/dao/etc/dao.png "Data Access Object")

## Applicability
Use the Data Access Object in any of the following situations

* when you want to consolidate how the data layer is accessed
* when you want to avoid writing multiple data retrieval/persistence layers

`下列情况可考虑使用DAO模式`
* `当需要统一数据层的访问时`
* `当希望避免编写多个数据检索或者持久化层时。`这句我不太理解，如果有不同的数据库或者持久化方案，还是得编写多个数据检索或者持久化的代码的，但是通过抽象层能够规范对外的接口，避免了对客户端的影响。
* 当希望避免反复编写复杂的数据读取或者存储的代码时

## Credits

* [J2EE Design Patterns](http://www.amazon.com/J2EE-Design-Patterns-William-Crawford/dp/0596004273/ref=sr_1_2)
