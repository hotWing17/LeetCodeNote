//86. 分隔链表Partition List

/**
 * 思路：
 * 维护两个链表(small和big)，并且遍历原链表，
 * 小于目标值则尾插入samll链表，否则尾插入big链表
 * 最后将两个链表连接起来，就得到所求。
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
    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0);
        small.next = null;
        ListNode m = small;         //small链表的尾指针，用于尾插入

        ListNode big = new ListNode(0);
        big.next = null;
        ListNode n = big;           //big链表的尾指针，用于尾插入

        ListNode pointer = head;    //遍历原链表的指针

        ListNode tmp;               //由于遍历指针所指引的节点尾插入之后，会丢失后继节点，所以使用tmp指针暂时保管后继节点

        while(pointer != null){
            tmp = pointer.next;
            if(pointer.val < x)m = insertTail(m, pointer);
            else n = insertTail(n, pointer);
            pointer = tmp;
        }

        m.next = big.next;          //连接small和big链表
        return small.next;
    }

    // 将p节点插入到tail节点的后面
    public ListNode insertTail(ListNode tail, ListNode p){
        tail.next = p;
        p.next = null;
        return p;
    }
}