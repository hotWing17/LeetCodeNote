// 101. 对称二叉树 Symmetric Tree
// 思路：传入两个二叉树，首先判断结点是否相等，相等则继续判断左右子树，A树左节点和B树右节点应该相等，否则不是对称

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;        // 根结点为空
        else return childSymmetric(root.left, root.right);  // 判断左右两个子树是否对称
    }

    private boolean childSymmetric(TreeNode leftChild, TreeNode rightChild){
        if(leftChild == null && rightChild == null)return true;         // 传入的左右子树为空，则肯定对称
        else if(leftChild == null || rightChild == null)return false;   // 传入的左右子树中有一个为空，另一个不为空，则肯定不对称

        if(leftChild.val == rightChild.val){
            return childSymmetric(leftChild.left, rightChild.right) && childSymmetric(leftChild.right, rightChild.left);
        } else return false;
    }
}