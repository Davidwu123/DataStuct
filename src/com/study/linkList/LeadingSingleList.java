package com.study.linkList;

import com.study.common.Log;

/**
 * @author wuwei
 * @title: LeadingSingleList
 * @projectName DataStuct
 * @description: 带头单链表(含有哨兵结点)
 * @date 2019-12-02 15:41
 */
public class LeadingSingleList<T> extends BaseList<T> {
    private static final String TAG = LeadingSingleList.class.getSimpleName();
    private Node mHeaderNode;
    //header->emptyNode(即为header.next/哨兵结点)->Node1->Node2->Node...

    public LeadingSingleList() {
        mHeaderNode = new Node(null);//header指向emptyNode
    }

    @Override
    void insertFromHead(T val) {
        checkDataValid(val);
        Node node = new Node(val);
        node.setNext(mHeaderNode.getNext());
        mHeaderNode.setNext(node);
    }

    @Override
    void insertFromTail(T val) {
        checkDataValid(val);
        Node newNode = new Node(val);
        //找到最后一个结点的next为null时赋值
        Node node = mHeaderNode.getNext();
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(newNode);
    }

    @Override
    void insertBefore(Node<T> node, T val) {
        checkDataValid(val);
        //插入指定结点的前面，首先需要找到该节点的前一个结点
        //前面结点为正常结点；前面结点为最后一个结点(node == null)
        Node newNode = new Node(val);
        if (node == null) {//直接在尾部添加结点
            insertFromTail(val);
        } else {
            Node preNode = mHeaderNode;
            while (preNode != null) {
                if (preNode.getNext() == node) {
                    //preNode->Node变为preNode->newNode->Node
                    newNode.setNext(node);
                    preNode.setNext(newNode);
                    break;
                }
                preNode = preNode.getNext();
            }
        }
    }

    @Override
    void insertAfter(Node<T> node, T val) {
        checkDataValid(val);
        Node newNode = new Node(val);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
    }

    @Override
    void delete(T val) {
       //empty 8 2 1
        Node node = mHeaderNode.getNext();//8
        if (node != null) {
            if (node.getData().equals(val)) {
                mHeaderNode.setNext(node.getNext());
            }
            while (node.getNext() != null) {
                if (node.getNext().getData().equals(val)) {
                    node.setNext(node.getNext().getNext());
                    //break;
                }
                node = node.getNext();
            }
        }
    }

    @Override
    Node queryNode(T val) {
        Node retNode = null;
        //遇到val相等时返回该结点
        Node node = mHeaderNode.getNext();
        while (node != null && node.getData() != val) {
            node = node.getNext();
        }
        if (node != null) {
            retNode = node;
            Log.d(TAG, "query node is " + val.toString());
        }
        return retNode;
    }

    @Override
    void printAllNode() {
        Node node = mHeaderNode.getNext();
        while (node != null) {
            Log.d(TAG, "node is " + node.getData().toString());
            node = node.getNext();
        }
    }
}
