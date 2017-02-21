翻译[iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns/tree/master/poison-pill)的毒药模式

## Intent
Poison Pill is known predefined data item that allows to provide
graceful shutdown for separate distributed consumption process.

`毒药模式是指，通过发送预定义好的数据给分布式部署的消费者进程（通常不在一个主机），让其优雅地关闭。`

`
写完整个代码，感觉蛮...蛮...奇怪的，什么样的场景下会需要这个模式呢？
首先场景肯定是出现在分布式的部署中，生产者已经明确了不会再生产东西了，
那么就给消费者发毒药，消费者知道不再用它继续处理后，就退出了。很显然，节约了系统资源。

可以想象一下，消费者每天会定时启动，接受消息直接收到毒药，然后自杀。
如果不发送毒药，那么消费者自己也不敢自杀，因为不知道还么有没有消息需要处理。

所有整个过程有趣有趣...所以少年，还是多看代码吧`
`

![alt text](https://github.com/iluwatar/java-design-patterns/raw/master/poison-pill/etc/poison-pill.png)

## Applicability
Use the Poison Pill idiom when

* need to send signal from one thread/process to another to terminate

`当一个进程或者线程需要另一个进程或者线程中止时，可以使用毒药模式发送信号让其中止`

## Real world examples
* [akka.actor.PoisonPill](http://doc.akka.io/docs/akka/2.1.4/java/untyped-actors.html)
