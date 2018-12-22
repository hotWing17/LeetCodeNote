//61. 旋转链表Rotate List
/**
 * 思路：
 * 旋转数组，其实就是通过给出的 k 值，找到需要将链表切断的结点，然后将前后两截链表调换位置
 * 找到 切断的结点有一点需要注意的是，当 k 特别大时，可以遍历完数组的第一次之后，用链表长度对 k 求余,
 * 下一次遍历最多需要 n-1 次。
 * 时间复杂度 O(N)
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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0)return head;

        ListNode fast = head;
        int i = 0;
        //找到开始遍历的起点
        while(i < k){
            //k的数值较大时，可以用链表长度对 k 求余,只需要在遍历最多 n-1 次就可以找到开始遍历的起点。
            if(fast.next == null){
                fast = head;
                k = k % (i+1);
                i = -1;
            }
            else fast = fast.next;
            i++;
        }

        //找到分割点
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        
        if(slow.next == null)return head;   //遍历完发现，数组可以不用旋转，直接返回

        //调换两截链表
        ListNode tmp = slow.next;
        slow.next = null;
        fast.next = head;
        head = tmp;
        return tmp;
    }
}