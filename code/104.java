// 104. 二叉树的最大深度 Maximum Depth of Binary Tree
// 思路：递归方法，本节点加上左右子树中最深的节点数

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
    public int maxDepth(TreeNode root) {
        return getNodeCounter(root);
    }
    private int getNodeCounter(TreeNode node){
        if(node == null)return 0;
        return 1 + Math.max(getNodeCounter(node.left), getNodeCounter(node.right));
    }
}