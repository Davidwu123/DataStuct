package com.study.linkList;

/**
 * @author wuwei
 * @title: Node
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-11-3014:34
 */
public final class Node {
    private int size;
    private String data;
    private Node next;

    public int getSize() {
        return size;
    }

    public Node setSize(int size) {
        this.size = size;
        return this;
    }

    public String getData() {
        return data;
    }

    public Node setData(String data) {
        this.data = data;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "size=" + size +
                ", data='" + data + '\'' +
                ", next=" + next +
                '}';
    }
}
