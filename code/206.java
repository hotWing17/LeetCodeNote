//206. 反转链表
/**
 * 思路：
 * 取每个结点，头插入一个新的链表
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode first = new ListNode(0);
        ListNode p = head;
        ListNode tmp = null;
        while(p != null){
            tmp = p.next;
            p.next = first.next;
            first.next = p;
            p = tmp;
        }
        return first.next;
    }
}