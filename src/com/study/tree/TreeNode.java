package com.study.tree;

/**
 * @author wuwei
 * @title: TreeNode
 * @projectName DataStuct
 * @description: TODO
 * @date 2020-01-07 09:28
 */
public class TreeNode {
    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public TreeNode setData(int data) {
        this.data = data;
        return this;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
        return this;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public TreeNode setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
        return this;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
