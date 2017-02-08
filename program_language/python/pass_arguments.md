#### python参数的传递

译自[stackoverflow](http://stackoverflow.com/questions/986006/how-do-i-pass-a-variable-by-reference)的第一个答案

在python中，参数是传送是passed by assignment，而我们更为熟悉的是值传递(passed by value)和引用传递(passed by reference)，passed by assignment由两层意思：

1. 参数的确以引用了一个对象的方式传递（但引用确实是以值的方式在传递）。`其实我没太懂，但是下面的例子很清晰`

2. 根据数据类型，函数内参数的修改对外面的影响各不相同。也就是有些是可以变的，有些是不能变的。

总结一下根据上面的性质有两个表现：

* 如果向方法内传入了一个可变对象，方法内是获得了这个可变对象的引用，所以你修改了对象的内容(如list.append())时函数外界是可以感知的；但是一旦将这个引用重新赋值（重新与别的对象建立连接），那么从此与外界无关了，毕竟指向了不同对象。
* 如果向方法传入一个不可变对象，那就相当于是值传递，方法内的修改和方法外没关系。

下面举例说明:

##### List - 可变类型 

下面证明上面提到的：所以你修改了对象的内容(如list.append())时函数外界是可以感知的。

```python

def try_to_change_list_contents(the_list):
    print('got', the_list)
    the_list.append('four') #使用list的方法修改了内容 
    print('changed to', the_list)

outer_list = ['one', 'two', 'three']

print('before, outer_list =', outer_list)
try_to_change_list_contents(outer_list)
print('after, outer_list =', outer_list)

'''
#产出
before, outer_list = ['one', 'two', 'three']
got ['one', 'two', 'three']
changed to ['one', 'two', 'three', 'four'] 
after, outer_list = ['one', 'two', 'three', 'four'] #函数内的修改影响了外界
'''

```

下面证明上面提到的：但是一旦将这个引用重新赋值（重新与别的对象建立连接），那么从此与外界无关了，毕竟指向了不同对象。

```python
def try_to_change_list_reference(the_list):
    print 'got', the_list
    the_list = ['and', 'we', 'can', 'not', 'lie'] #重新与别的List建立的连接，引用了别的list对象
    print('set to', the_list)

outer_list = ['we', 'like', 'proper', 'English']

print('before, outer_list =', outer_list)
try_to_change_list_reference(outer_list)
print('after, outer_list =', outer_list)

'''
#产出
before, outer_list = ['we', 'like', 'proper', 'English']
got ['we', 'like', 'proper', 'English']
set to ['and', 'we', 'can', 'not', 'lie']
after, outer_list = ['we', 'like', 'proper', 'English'] #外界无关感知
'''

```


##### String - 不可变类型

下面证明上面提到的：如果向方法传入一个不可变对象，那就相当于是值传递，方法内的修改和方法外没关系，我们也无法在方法内修改到外界的值。

```python
def try_to_change_string_reference(the_string):
    print('got', the_string)
    the_string = 'In a kingdom by the sea' #修改与外界无关
    print('set to', the_string)

outer_string = 'It was many and many a year ago'

print('before, outer_string =', outer_string)
try_to_change_string_reference(outer_string)
print('after, outer_string =', outer_string)


'''
#产出
before, outer_string = It was many and many a year ago
got It was many and many a year ago
set to In a kingdom by the sea
after, outer_string = It was many and many a year ago
'''

```

(完)
