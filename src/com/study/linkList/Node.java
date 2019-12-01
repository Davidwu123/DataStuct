package com.study.linkList;

/**
 * @author wuwei
 * @title: Node
 * @projectName DataStruct
 * @description: TODO
 * @date 2019-11-3014:34
 */
public final class Node<T> {
    private T data;
    private Node next;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node setData(T data) {
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
                " data='" + data + '\'' +
                ", next=" + next +
                '}';
    }
}
