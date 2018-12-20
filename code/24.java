//24. 两两交换链表中的节点Swap Nodes in Pairs
/**
 * 思路：
 * 加入一个头结点，使代码根据有普遍性
 * 两两交换只需要操作指针
 * 需要注意的是，当交换到最后一个元素时，则不需要进行交换。
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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;          //排序空链表的情况
        ListNode first = new ListNode(-1);      //设置头结点，使代码具有 普遍性
        ListNode p = first;                     //p指针用于循环遍历所有结点
        first.next = head;
        ListNode tmp = null;                    //设计链表的操作，需要一个指针，暂存链表结点

        while(p.next != null && p.next.next != null){
            tmp = p.next;
            p.next = p.next.next;
            tmp.next = p.next.next;
            p.next.next = tmp;
            p = p.next.next;
        }
        return first.next;
    }
}