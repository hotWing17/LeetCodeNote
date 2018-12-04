//237. 删除链表中的节点
// 思路：平时的链表删除需要用到删除节点的前一个节点来进行操作，而本题这里由于获取不到前一个节点
// 所以需要删除的结点不应该删除，而是使用后一个结点的值覆盖这个结点，之后删除后一个结点
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode tmp = node.next;
        node.val = tmp.val;
        node.next = tmp.next;
    }
}