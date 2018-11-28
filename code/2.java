//2. 两数相加
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode a = l1;                        //a,b两个指针从头到尾分别对两个链表进行遍历
        ListNode b = l2;
        int carry = 0;                          //进位
        int tmp = 0;                            //存储“取数相加”的结果
        ListNode res = new ListNode(-1);        //“结果链表”的表头节点
        ListNode last = res;                    //尾部指针，便于插入

        while(a != null || b != null){
            tmp = (a == null ? 0 : a.val) + (b == null ? 0 : b.val) + carry;    //本算法的关键
            carry = tmp/10;                     //产生进位
            last.next = new ListNode(tmp%10);   //求余之后，生成新结点,从尾部插入"结果链表"
            last = last.next;
            a = a==null ? null : a.next;
            b = b==null ? null : b.next;
        }

        //当两个链表的已经遍历完成之后，最后还需要加上最后一次相加可能产生的进位到"结果链表"中
        if(carry > 0)last.next = new ListNode(carry);
        return res.next;
    }
}