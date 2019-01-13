// 面试题32：从上往下打印二叉树

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 思路：维持一个队列用来保存遍历过的结点的左右结点(空的就不进入队列了)，当最后队列为空时，层序遍历结束
 */

import java.util.ArrayList;
import java.util.LinkedList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        TreeNode tmp = root;
        while(tmp != null){

            result.add(tmp.val);    // 尾插入
            if(tmp.left != null)list.add(tmp.left);
            if(tmp.right != null)list.add(tmp.right);

            tmp = list.poll();      // 弹出头结点，为空时返回null
        }
        return result;
    }
}