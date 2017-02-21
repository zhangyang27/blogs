翻译[iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns/tree/master/poison-pill)的毒药模式

## Intent
Poison Pill is known predefined data item that allows to provide
graceful shutdown for separate distributed consumption process.
`毒药模式是指，通过发送预定义好的数据给分布式部署的消费者进程（通常不在一个主机），让其优雅地关闭。`

![alt text](https://github.com/iluwatar/java-design-patterns/raw/master/poison-pill/etc/poison-pill.png)

## Applicability
Use the Poison Pill idiom when

* need to send signal from one thread/process to another to terminate
`当一个进程或者线程需要另一个进程或者线程中止时，可以使用毒药模式发送信号让其中止`

## Real world examples
* [akka.actor.PoisonPill](http://doc.akka.io/docs/akka/2.1.4/java/untyped-actors.html)
