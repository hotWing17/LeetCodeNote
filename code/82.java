//82. 删除排序链表中的重复元素 II
// 思路：设置快慢指针，慢指针指向(当前面遍历中)最后一个确定的非重复元素
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

        if(head == null || head.next == null)return head;

        ListNode first = new ListNode(head.val - 1);
        first.next = head;

        ListNode slow = first;
        ListNode fast = head.next;


        while(fast != null){
            if(slow.next.val == fast.val)fast = fast.next;
            else if(slow.next.next == fast){
                slow = slow.next;
                fast = fast.next;
            }
            else{
                slow.next = fast;
                fast = fast.next;
            }
        }
        if(slow.next.next != null)slow.next = null;

        return first.next;
    }
}