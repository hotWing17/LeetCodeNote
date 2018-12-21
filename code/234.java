//234. 回文链表Palindrome Linked List
/**
 * 思路：
 * 判断回文，需要找到链表的中间位置，将链表分为两段(list1 和 list2)
 * 通过链表反转函数，反转第一段链表，得到list1
 * 遍历比较两个链表，当两个链表完全一致时，则原链表是一个回文链表
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
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)return true;

        //设置头结点，使找到的slow结点位置在奇数个结点和偶数个结点的情况下，都可以正常的将原链表分为两段(画图示意)
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode slow = first;
        ListNode fast = head;

        //找到链表的中间结点
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //此模块将原链表从中间分为两个链表(list1 和 list2)
        ListNode list1 = null;
        ListNode list2 = null;
        if(fast == null)list2 = slow.next;
        else list2 = slow.next.next;
        slow.next = null;
        list1 = first.next;

        list1 = reverseList(list1); //反转链表

        //遍历比较两个链表，当两个链表完全一致时，则原链表是一个回文链表
        while(list1 != null){
            if(list1.val == list2.val){
                list1 = list1.next;
                list2 = list2.next;
            }else return false;
        }
        return true;
    }

    //反转链表函数
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