原来学[机器学习](http://cs231n.github.io/python-numpy-tutorial/)的时候偶然知道了一种简洁易懂的快排实现代码，用python写的：

```python
def quicksort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) / 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quicksort(left) + middle + quicksort(right)
    
print quicksort([3,6,8,10,1,2,1])
# Prints "[1, 1, 2, 3, 6, 8, 10]"
```

感叹简洁性的同时，也很好奇python的缺点，简单总结下：
* 性能差、跑得慢。特别是GIL([Global Interpreter Lock](https://wiki.python.org/moin/GlobalInterpreterLock))，这个锁能够阻止多个原生的线程同时执行python的字节码。这里有张图很有意思，跳街舞的时候有一个人跳，别的人在加油。
	* PyPy、CPython有这个问题，但是Jpython没有。
	* 可以通过多进程来解决这个问题，但会增加内存消耗。
	* 如果是CPU密集型，这个问题比较严重。但如果是文件IO或者网络IO密集的，那么这个问题还好。
* 性能差的另一个原因还因为使用了动态类型，经常检查变量类型。加速了开发过程，但是降低了运行速度。瓶颈部分改写成C能缓解这个问题。
	* PyPy 的 JIT技术(即时编译器) 一定程度提高了运行速度。但类型检查依然降低运行速度。
	* java 的静态类型和JIT使得其获得接近于C的性能。
* 有些人比较介意python函数式编程的一些缺陷，比如lambda只能有一个表达式。但我觉得这很好啊，可以降低代码复杂度。
* 有些人比较介意python的OOP的实现，比如魔术方法、显式的self、成员方法是公共方法。至少我个人觉得显示的self真是有点恶心。
* python3的迁移太缓慢，这是一个社区问题。


实际上每种编程语言都有缺点，我要做的就是做好权衡和取舍。比较典型的场景是：如果瓶颈在网络IO（或者文件IO），不在计算（不是CPU密集型）或者内存，那么使用python应该就是合适的，毕竟python相比C能够极大提高开发速度。

参考:
* [What are the disadvantages of Python?](https://www.quora.com/What-are-the-disadvantages-of-Python)
* [What are the advantages of Python over C++?](https://www.quora.com/What-are-the-advantages-of-Python-over-C++)






