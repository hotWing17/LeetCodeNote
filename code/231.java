// 231.2的幂 Power of Two

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)return false;
        int tmp = n;
        while(tmp != 1){
            if(tmp % 2 == 0)tmp = tmp >> 1;
            else return false;
        }
        return true;
    }
}