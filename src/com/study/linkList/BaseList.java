package com.study.linkList;

/**
 * @author wuwei
 * @title: BaseList
 * @projectName DataStruct
 * @description: TODO
 * @date 2019-11-3014:34
 */
public abstract class BaseList<T> {
    //从头部插入
    abstract void insertFromHead(T val);
    //从尾部插入
    abstract void insertFromTail(T val);

    //在指定节点前插入
    abstract void insertBefore(Node<T> node, T val);

    //在指定节点后面插入
    abstract void insertAfter(Node<T> node, T val);

    //删除
    abstract void delete(T val);
    //查询
    abstract Node queryNode(T val);

    abstract void printAllNode();

    protected void checkDataValid(T val) {
        if (val == null) {
            throw new IllegalArgumentException("val can not be null");
        }
    }

}
