//203. 移除链表元素Remove Linked List Elements
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode first = new ListNode(0);    //加入一个头结点
        first.next = head;
        ListNode p = first;
        while(p != null && p.next != null){
            if(p.next.val == val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return first.next;
    }
}