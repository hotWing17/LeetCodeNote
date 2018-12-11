//83. 删除排序链表中的重复元素Remove Duplicates from Sorted List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;
        ListNode tmp = head;
        ListNode p = head.next;
        while(p != null){
            if(tmp.val == p.val)p = p.next;
            else{tmp.next = p; tmp = p;}
        }
        tmp.next = null;
        return head;
    }
}