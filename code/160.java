//160. 相交链表

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 方法一：暴力方法
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p = headA;
        ListNode q = headB;

        while(p != null){
            while(q != null){
                if(p == q)return p;
                else q = q.next;
            }
            p = p.next;
            q = headB;
        }
        return null;
    }
}

// 方法二：缩小差距法(参考完成)
/*
 * 思路：
 * 想到既然两个指针分别遍历走完链表是不同长度，那就想办法让两个指针的遍历经过的路径长度是一样的
 * 既 p1指针遍历完"A"链表之后，又开始遍历“B”链表，同理操作p2指针，
 * 在这种情况下，两个指针会同时到达指针尾部，如果两个链表存在相交结点，则两个指针的第一次重合，就是链表相交的地方
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            if(p1 == null)p1 = headB;
            else p1 = p1.next;

            if(p2 == null)p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}