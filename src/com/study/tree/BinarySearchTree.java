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
     *
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
     *
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
     *
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
     *
     * @param root
     */
    public void recMidPrintTree(TreeNode root) {
        if (root == null) return;
        recMidPrintTree(root.getLeftNode());
        Log.d(BinarySearchTree.class, root.toString());
        recMidPrintTree(root.getRightNode());
    }


    /**
     * 删除
     * @param root
     * @param deleteVal
     */
    public void deleteTreeNode(TreeNode root, int deleteVal) {
        TreeNode p = root;//当前节点（后面沦为需要删除的节点）
        TreeNode pp = null;//父节点
        //找到需要删除的节点
        //1.删除节点左右子节点都存在
        //2.删除节点只有一个子节点或无子节点
        while (p != null && p.getData() != deleteVal) {
            pp = p;
            if (p.getData() < deleteVal) {
                p = p.getRightNode();
            } else {
                p = p.getLeftNode();
            }
        }
        //跳出条件：要么找到符合要求的节点；要么遍历所有没找到
        if (p == null) return;
        //p包含左右子节点
        if (p.getLeftNode() != null && p.getRightNode() != null) {
            //找到p右子树中最小的值(在右子树的最左边)
            TreeNode minP = p.getRightNode();//BUG mimP = p.right而非minP = p，因为需要从右侧开始，当前节点肯定不算，否则会走到左子树中
            TreeNode minPP = p;
            while (minP.getLeftNode() != null) {
                minPP = minP;
                minP = minP.getLeftNode();
            }
            Log.d(TAG, "11p node " + p.toString());
            Log.d(TAG, "22p node " + minP.toString());
            Log.d(TAG, "33p node " + minPP.toString());
            //退出条件为minP.getRightNode() == null;
            p.setData(minP.getData());//将minP的值设置到需要删除的位置的节点中
            //将minP标记为p,由后面逻辑来处理
            p = minP;
            pp = minPP;
            //至此下面逻辑即变为删除节点只有一个子节点或无子节点(不需要置换值，只需要删除后面的节点或者子节点位置改变即可)
        }
        //删除只有一个子节点或无子节点的父节点
        TreeNode child = null;
        if (p.getLeftNode() != null) {
            child = p.getLeftNode();
        } else if (p.getRightNode() != null) {
            child = p.getRightNode();
        }
        //获取到了子节点，下面开始将child赋值给pp
        if (pp == null) {
            //pp一直没更新，表示root.data = deleteVal，即需要删除的是根节点，则将root的child赋值给root即可
            root = child;
        } else if (pp.getLeftNode() == p) {//BUG:pp.left == p而非pp.left ！= null（pp.getLeftNode()是正常的节点）
            //p为需要删除的节点，需要用child代替
            pp.setLeftNode(child);
        } else {
            //pp.setRightNode() == p
            pp.setRightNode(child);
        }
        Log.d(TAG, "p node " + p.toString());
    }


}
