// 面试题31：栈的压入、弹出序列

// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
// 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

// 思路：添加一个辅助栈，若栈顶元素和弹出序列当前元素不等，则向辅助栈压入一个压入序列当前元素
// 若栈顶元素和弹出序列当前元素相等，则辅助栈弹出栈顶元素，弹出序列指针指向后一个元素
// 若栈顶元素和弹出序列当前元素不等,且压入序列已经全部压入了，则此时返回false，此时该弹出序列不正确。

import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        Integer head;
        while(j < popA.length){
            head = list.peek();                     // 查看栈顶元素，空的话为null
            if(head == null || head != popA[j]) {
                if(i == pushA.length)return false;  //需要入栈的数字都已经入栈，但是仍没有找到需要弹出的数字，则报错
                list.push(pushA[i++]);
            }else{
                list.poll();    // 弹出栈顶元素，空的话为null
                j++;
            }
        }
        return true;
    }
}