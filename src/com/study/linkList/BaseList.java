package com.study.linkList;

/**
 * @author wuwei
 * @title: BaseList
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-11-3014:34
 */
public abstract class BaseList {
    //插入
    abstract void insert(Node node);
    //删除
    abstract void delete(Node node);
    //查询
    abstract Node queryNode(String data);

}
