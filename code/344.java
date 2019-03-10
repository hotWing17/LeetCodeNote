// 344. 反转字符串 Reverse String
// 思路：前后指针指向，调换位置
class Solution {
    public void reverseString(char[] s) {

        char tmp = 0;
        int start = 0;
        int end = s.length - 1;
        while(start < end){
            tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}