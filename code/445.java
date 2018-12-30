// 445. 两数相加 II

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 方法一：翻转法
// 翻转两个链表，从头(从个位数)相加，得到的结果再次翻转，则可以获得所求结果链表。
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = listRe(l1);
        l2 = listRe(l2);
        return listRe(addTwoNumbersRe(l1, l2));
    }

    // 翻转链表
    public ListNode listRe(ListNode l1) {
        ListNode first = new ListNode(0);
        first.next = null;
        ListNode p = l1;
        ListNode tmp = null;
        while(p != null){
            tmp = p.next;
            p.next = first.next;
            first.next = p;
            p = tmp;
        }
        return first.next;
    }

    // 相加两个逆序链表
    public ListNode addTwoNumbersRe(ListNode l1, ListNode l2) {

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


// 方法二：栈相加法
// 思路： 不翻转数组，使用一个栈结构保存两个数，从个位数开始相加
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 将两个链表放到栈里面去
        LinkedList<Integer>list1 = new LinkedList<Integer>();
        LinkedList<Integer>list2 = new LinkedList<Integer>();
        ListNode p = l1;
        while(p != null){
            list1.push(p.val);
            p = p.next;
        }
        p = l2;
        while(p != null){
            list2.push(p.val);
            p = p.next;
        }

        // 从栈顶开始，分别从两个栈中去两个数，相加，同时需要加上进位
        // 得到的结果对10求余之后，头插入到结果链表，进位继续传给下一个循环
        ListNode res = null;
        int carry = 0;          //进位
        while(!list1.isEmpty() || !list2.isEmpty() || carry != 0){
            int left = list1.isEmpty() ? 0 : list1.pop();
            int right = list2.isEmpty() ? 0 : list2.pop();
            int val = (left + right + carry) % 10;
            carry = (left + right + carry) / 10;

            ListNode insertNode = new ListNode(val);
            insertNode.next = res;
            res = insertNode;
        }
        return res;
    }
}