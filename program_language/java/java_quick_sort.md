原来学[机器学习](http://cs231n.github.io/python-numpy-tutorial/)的时候偶然知道了一种简洁易懂的快排实现代码，但是用python写的。
这次改用java来写，才真正感受到了python的简洁。

先看看python的代码：
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

再看看java的，写的时候也发现了不用动态数组根本完成不了。
```java
package sorter;

import java.util.*;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = {9, 4, 8, 3, 1, 2, 5};
		ArrayList<Integer> arr=new ArrayList<Integer>();	
		for(int i : a1) {
			arr.add(i);
		}
		System.out.print("Initial Array : ");
        for(int i : arr) {
        	System.out.print(i);
		}
        System.out.println();
        
        arr = (ArrayList<Integer>) sort(arr);
        
        System.out.print("after sort Array : ");
        for(int i : arr) {
        	System.out.print(i);
		}
        System.out.println();
	}
	/**
	 * 需要动态数组
	 */
	public static List<Integer> sort(List<Integer> arr) {
		if(arr.size() <= 1){
			return arr;
		}
		int pivot = arr.get(arr.size()/2);
		List<Integer> left=new ArrayList<Integer>();
		List<Integer> middle=new ArrayList<Integer>();
		List<Integer> right=new ArrayList<Integer>();
		
        for(Integer num: arr) {
            if(num == pivot){
            	middle.add(num);
            }else if(num > pivot){
            	right.add(num);
            }else if(num < pivot){
            	left.add(num);
            }
        }
        left = sort(left);
        right = sort(right);
        left.addAll(middle);
        left.addAll(right);
		return left;
    }
}

```
