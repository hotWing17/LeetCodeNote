// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Example 2:

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

// 思路：
// 1、循环判断要加1的末位数是否为“9”，为“9”则填0，将"p"向前移动，跳出条件为下
// 2、p此时所在位置加1，判断是否【0】位置是否大于10，是则需要创建新数组

class Solution {
    public int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        while(digits[p] == 9 && p > 0){
            digits[p] = 0;
            p--;
        }
        digits[p] = digits[p] + 1;
        if(digits[0] < 10)return digits;
        else{
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
    }
}