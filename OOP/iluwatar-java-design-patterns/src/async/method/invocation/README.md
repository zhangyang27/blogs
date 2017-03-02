翻译[iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns/tree/master/async-method-invocation)异步方法调用模式

## Intent
Asynchronous method invocation is pattern where the calling thread
is not blocked while waiting results of tasks. The pattern provides parallel
processing of multiple independent tasks and retrieving the results via
callbacks or waiting until everything is done. 

`异步方法调用是这样一种模式：调用者（一个线程）调用方法时不会阻塞，也就是不会等待任务的结果。
该模式让多个独立的任务并发执行，可以利用回调获得任务的结果，也可以调用者等待所有的任务结束再获得结果（就像map/reduce一样必须等待所有的map结束才能执行reduce）。
`


![alt text](https://github.com/iluwatar/java-design-patterns/raw/master/async-method-invocation/etc/async-method-invocation.png "Async Method Invocation")

抄完代码后，觉得设计的还是略微复杂的，还需要多思考。

除外，还有java 8的新特性、函数式编程和新的类Optional的使用，这些不熟悉让我也比较困惑。

## Applicability
Use async method invocation pattern when

* you have multiple independent tasks that can run in parallel
* you need to improve the performance of a group of sequential tasks
* you have limited amount of processing capacity or long running tasks and the
  caller should not wait the tasks to be ready

`下列情况可以使用异步方法调用`
* `有多个独立的小任务需要并发执行`
* `需要改进一组按序执行任务的性能` 这个我蛮困惑，怎么改进？这组按序执行的任务的结果前后不依赖吗？后一个任务的输入不是前一个任务的输出？
* `当调用者不需要等待某项任务完成就可以继续运行时可以使用该模式。这项任务可能是一个运行时间很长的任务。` 上面还提到了`如果运行资源有限时`，这也使我感到困惑，可能我缺乏并行计算的背景吧。


## Real world examples

* [FutureTask](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/FutureTask.html), [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html) and [ExecutorService](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html) (Java)
* [Task-based Asynchronous Pattern](https://msdn.microsoft.com/en-us/library/hh873175.aspx) (.NET)
