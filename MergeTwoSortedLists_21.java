/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
        ListNode temp = null;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                temp = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }
            tail.next = temp;
            tail = temp;
        }

        if(l1 == null){tail.next = l2;}
        else{tail.next = l1;}
        return head.next;
    }
}