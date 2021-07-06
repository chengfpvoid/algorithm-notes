package org.cheng.algo.lc106;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreeSolutions {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder, 0,inorder.length - 1,postorder, 0, postorder.length - 1);

    }

    /**
     * 先通过后序位置找到根，然后根据中序根的位置划分左右子树的界限，递归的构建树
     * @param inorder 中序遍历列表
     * @param inLeft 中序起点
     * @param inRight 中序终点
     * @param postorder 后序遍历列表
     * @param postLeft 后序遍历起点
     * @param postRight 后序遍历终点
     * @return
     */
    public  TreeNode buildTree(int[] inorder, int inLeft,int inRight, int[] postorder,int postLeft,int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int p = -1;
        // 中序位置的根位置 以此划分左右子树边界
        for(int i = inLeft; i <= inRight; i++) {
            if(inorder[i] == postorder[postRight]) {
                p = i;
                break;
            }
        }
        // 左子树的元素个数
        int leftNum = p - inLeft;

        root.left = buildTree(inorder, inLeft, p-1, postorder, postLeft, postLeft + leftNum - 1);

        root.right = buildTree(inorder, p + 1, inRight, postorder, postLeft + leftNum, postRight - 1);
        return root;
    }



    /**
     * Definition for a binary tree node.
     */
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }


}
