package com.study.tree;

import com.study.common.Log;

/**
 * @author wuwei
 * @title: TestMain
 * @projectName DataStuct
 * @description: TODO
 * @date 2020-01-07 09:49
 */
public class TestMain {
    private static final String TAG = TestMain.class.getSimpleName();

    public static void main(String[] a) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode rootNode = new TreeNode(3);
        binarySearchTree.recInsertTreeNode(rootNode, 2);
        binarySearchTree.noRecInsertTreeNode(rootNode, 10);
        binarySearchTree.noRecInsertTreeNode(rootNode, 4);
        binarySearchTree.recInsertTreeNode(rootNode, 5);
        binarySearchTree.recInsertTreeNode(rootNode, 7);
        binarySearchTree.recInsertTreeNode(rootNode, 8);
        binarySearchTree.recInsertTreeNode(rootNode, 12);
        binarySearchTree.recMidPrintTree(rootNode);
        Log.d(TAG, "rec find node  " + binarySearchTree.recFindNode(rootNode, 4).toString());
        Log.d(TAG, "no rec find node  " + binarySearchTree.noRecFindNode(rootNode, 4).toString());

    }
}
