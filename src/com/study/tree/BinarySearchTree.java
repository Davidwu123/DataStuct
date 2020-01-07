package com.study.tree;

import com.study.common.Log;

/**
 * @author wuwei
 * @title: BinarySearchTree
 * @projectName DataStruct
 * @description: TODO
 * @date 2020-01-07 09:28
 */
public class BinarySearchTree {
    private static final String TAG = BinarySearchTree.class.getSimpleName();

    public TreeNode recFindNode(TreeNode root, int data) {
        if (root == null) return null;
        if (root.getData() == data) {
            return root;
        } else if (root.getData() < data) {
            return recFindNode(root.getRightNode(), data);
        } else {
            return recFindNode(root.getLeftNode(), data);
        }
    }


    /**
     * 非递归查找节点
     * @param root
     * @param data
     * @return
     */
    public TreeNode noRecFindNode(TreeNode root, int data) {
        if (root == null) return null;
        while (root != null) {
            if (root.getData() == data) {
                return root;
            } else if (root.getData() < data) {
                root = root.getRightNode();
            } else {
                root = root.getLeftNode();
            }
        }
        return null;
    }


    /**
     * 非递归插入数据
     * @param root
     * @param data
     */
    public void noRecInsertTreeNode(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            while (root != null) {
                if (root.getData() < data) {
                    //重要：如果节点为空，表示数据应该放置在该位置，同时指针set
                    if (root.getRightNode() == null) {
                        root.setRightNode(new TreeNode(data));
                        return;
                    }
                    root = root.getRightNode();
                } else if (root.getData() > data) {
                    if (root.getLeftNode() == null) {
                        root.setLeftNode(new TreeNode(data));
                        return;
                    }
                    root = root.getLeftNode();
                }
            }
        }
    }


    /**
     * 递归插入
     * @param root
     * @param data
     */
    public void recInsertTreeNode(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            if (root.getData() < data) {//数据应该插入右边
                if (root.getRightNode() == null) {
                    root.setRightNode(new TreeNode(data));
                } else {
                    recInsertTreeNode(root.getRightNode(), data);
                }
            } else if (root.getData() > data) {
                if (root.getLeftNode() == null) {
                    root.setLeftNode(new TreeNode(data));
                } else {
                    recInsertTreeNode(root.getLeftNode(), data);
                }
            }
        }
    }


    /**
     * 递归中序遍历(按照大小顺序显示)
     * @param root
     */
    public void recMidPrintTree(TreeNode root) {
        if (root == null) return;
        recMidPrintTree(root.getLeftNode());
        Log.d(BinarySearchTree.class, root.toString());
        recMidPrintTree(root.getRightNode());
    }

}
