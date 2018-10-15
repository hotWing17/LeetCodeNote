// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

// 方法一：
// 思路：转换成字符串，然后一头一尾遍历，判断是否相同
class Solution {
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        String[] charArr = str.split("");
        int head = 0;
        int tail = charArr.length - 1;
        if (head == tail) return true;
        while (head < tail) {
            if (!charArr[head].equals(charArr[tail])) {
                return false;
            } else {
                head++;
                tail--;
            }
        }
        return true;
    }
}

// 方法二：
// 思路：不用分割函数，采用toCharArray()变成字符数组
class Solution {
    public static boolean isPalindrome(int x) {
        char[] charArr = ((Integer)x).toString().toCharArray();
        int head = 0;
        int tail = charArr.length - 1;
        if (head == tail) return true;
        while (head < tail) {
            if (charArr[head] != charArr[tail]) {
                return false;
            } else {
                head++;
                tail--;
            }
        }
        return true;
    }
}
