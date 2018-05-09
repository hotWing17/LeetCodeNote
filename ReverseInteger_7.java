// Given a 32-bit signed integer, reverse digits of an integer.

// Note:

// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 

// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

class Solution {
    public int reverse(int x) {
        
        long s = 0;
        while (x != 0) {
            s = s * 10 + x % 10;
            x /= 10;
        }
        
        /*
        if (s > Integer.MAX_VALUE || s < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) s;
        */

        // ??????
        int test = (int) s;
        return s == test ? test : 0;
        
    }
}