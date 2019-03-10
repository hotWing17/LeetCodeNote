// 226. 翻转二叉树  Invert Binary Tree
// 思路：利用递归的思想，分别翻转左右子树之后，然后调换两个子树位置，递归调用

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return root;
        TreeNode invertLeft = invertTree(root.left);    // 反转左子树
        TreeNode invertRight = invertTree(root.right);  // 反转右子树
        root.right = invertLeft;
        root.left = invertRight;
        return root;
    }
}