/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = null;
        ListNode del = head;
        ListNode q = head;
        
        
        for(int i = 0; i < n-1; i++){
            q = q.next;
        }
        
        while(q.next != null){
            p = del;
            del = del.next;
            q = q.next;
        }

        if(p == null){
            return del.next;
        }else{
            p.next = del.next;
        }
        return head;
    }
}


//参考
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;

        for(int i = 0; i < n; i++){
            q = q.next;
        }

        if(p == null){
            return p.next;
        }else{
            while(q.next != null){
                p = p.next;
                q = q.next;
            }
            p.next = p.next.next;
        }
        return head;
    }
}