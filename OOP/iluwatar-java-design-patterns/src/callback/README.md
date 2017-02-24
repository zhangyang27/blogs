翻译[iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns/tree/master/callback)的回调模式

## Intent
Callback is a piece of executable code that is passed as an
argument to other code, which is expected to call back (execute) the argument
at some convenient time.

`回调模式是指将可执行的一小段代码以参数的形式传递给另外一段代码，这段代码在会在合适的时候调用(回调)以参数传入的小段代码。`

![alt text](https://github.com/iluwatar/java-design-patterns/raw/master/callback/etc/callback.png "Callback")

## Applicability
Use the Callback pattern when

* when some arbitrary synchronous or asynchronous action must be performed after execution of some defined activity.
* `当任何同步或者异步的行为必须在另一个确定好的活动完成之后执行时可以使用回调模式。`
* `其实我没太理解为什么一定要说同步或者异步，在我们看来就是另一个行为需要等待某一个行为完成后才执行`

## Real world examples

* [CyclicBarrier](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CyclicBarrier.html#CyclicBarrier%28int,%20java.lang.Runnable%29) constructor can accept callback that will be triggered every time when barrier is tripped.
