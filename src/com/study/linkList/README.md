# 链表使用注意事项

## 1.指针(引用)的含义
值中存储的是目标对象在存储空间中的首地址，并非目标对象的真实数据
## 2.注意指针丢失和内存泄漏
**丢失**:

e.g.在Node1和Node3之间插入Node2
若按照如下1和2的顺序执行后，Node1.next指向Node2,但Node2的next还是赋值的是自身，所以从Node2开始整个链表就断开了
```
1.Node1.next = Node2
2.Node2.next = Node1.next
```
因此以上正确的流程应为：
```
1.Node2.next = Node1.next
2.Node1.next = Node2
```
## 3.考虑边界(极端)问题
1）链表为空
2）只有一个数据
3）有两个数据
4）n个数据



