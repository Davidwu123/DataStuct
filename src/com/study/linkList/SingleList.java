package com.study.linkList;

import com.study.common.Log;

/**
 * @author wuwei
 * @title: SingleList
 * @projectName DataStruct
 * @description: 单链表
 * @date 2019-11-3014:30
 */
public final class SingleList<T> extends BaseList<T> {
    private static final String TAG = SingleList.class.getSimpleName();

    //链表的头节点
    private Node mHeaderNode = null;


    @Override
    void insertFromHead(T val) {
        checkDataValid(val);
        Node node = new Node(val);
        node.setNext(mHeaderNode);
        mHeaderNode = node;
    }

    @Override
    void insertFromTail(T val) {
        checkDataValid(val);
        Node newNode = new Node(val);
        if (mHeaderNode == null) {
            mHeaderNode = newNode;
        } else {
            Node node = mHeaderNode;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
    }

    @Override
    void insertBefore(Node<T> node, T val) {
        checkDataValid(val);
        if (node == null) {
            return;
        }
        //node为正常节点，需要知道前一个节点preNode的位置，newNode.next = preNode.next; preNode.next = newNode
        //node前面没有节点，即头节点
        if (node == mHeaderNode) {
            insertFromHead(val);//直接插入现有的头节点前面
        } else {
            Node newNode = new Node(val);
            //找到该节点的前面节点
            Node preNode = mHeaderNode;
            while (preNode != null && preNode.getNext() != node) {
                preNode = preNode.getNext();
            }
            if (preNode != null) {
                newNode.setNext(node);
                preNode.setNext(newNode);
            }
        }
    }

    @Override
    void insertAfter(Node<T> node, T val) {
        checkDataValid(val);
        if (node == null) {
            return;
        }
        Node newNode = new Node(val);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
    }

    /**
     * 1.链表为null,return
     * 2.链表第一个节点，header = node.next
     * 3.链表第n个, (n-1).next = n.next
     *
     * @param val
     */
    @Override
    void delete(T val) {
        Node node = mHeaderNode;
        if (node != null) {
            if (node.getData().equals(val)) {
                mHeaderNode = node.getNext();
            }
//            else {//bug1:如果加上else，则只会删除头节点，后面不会继续走了
            while (node.getNext() != null) {
                if (node.getNext().getData().equals(val)) {
                    node.setNext(node.getNext().getNext());
//                        break;//加上该标志只删除第一个遇到的，否则删除全部该val的节点
                }
                node = node.getNext();
            }
//            }
        }
    }



    //还有一种是按照index查找Node，同理从头遍历，position为内部变量，自动维护
    @Override
    Node queryNode(T val) {
/*        实现一
        Node retNode = null;
        Node node = mHeaderNode;
        while (node != null) {
            if (node.getData().equals(data)) {
                retNode = node;
                break;
            }
            node = node.getNext();
        }*/

        //实现二，recommend
        Node retNode = mHeaderNode;
        while (retNode != null && !retNode.getData().equals(val)) {
            retNode = retNode.getNext();
        }
        return retNode;
    }

    @Override
    void printAllNode() {
        Node node = mHeaderNode;
        while (node != null) {
            Log.d(TAG, node.getData().toString());
            node = node.getNext();
        }
    }
}
