// 141.环形链表
// 思路：双指针方法，设置一个慢指针(一次走一步)，设置一个快指针(一次走两步)
// 当存在环的时候，则快指针第二次遍历数组的时候，会与慢指针重合，否则链表不存在环
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)return false;
        ListNode slow = head;       //慢指针
        ListNode fast = head.next;  //快指针
        while(fast != slow){
            if(fast == null || fast.next == null){return false;}
            slow = slow.next;       //慢指针走一步
            fast = fast.next.next;  //快指针走两步
        }
        return true;
    }
}