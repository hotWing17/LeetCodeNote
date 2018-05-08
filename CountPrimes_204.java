// Description:

// Count the number of prime numbers less than a non-negative number, n.

// 方法一
// 思路：写的死循环，500+ms
class Solution {
    public int countPrimes(int n) {
        if(n < 3) return 0;
        int count = 1;
        boolean flag = false;
        for(int i = 3; i < n; i = i + 2){
            for(int j = 3; j <= Math.sqrt(i); j = j + 2){
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){count++;}
            flag = false;
        }
        return count;
    }
}

// 方法二(看leetcode好的解决方法 29ms)
// 思路：建立一个布尔数组，判断是否为素数，同时计算它的倍数置为非素数
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] nonPrimes = new boolean[n];
        for(int i = 2; i < n; i++){
            if(!nonPrimes[i]){
                count++;
                for(int j = 2; j*i < n; j++){
                    nonPrimes[j*i] = true;
                }
            }
        }
        return count;
    }
}


// 方法三(自己改进 21ms)
// 思路：
class Solution {
    public int countPrimes(int n) {
        if(n < 3)return 0;
        int count = 1;
        boolean[] nonPrimes = new boolean[n];
        for(int i = 3; i < n; i += 2){
            if(!nonPrimes[i]){
                count++;
                for(int j = 2; j*i < n; j++){
                    nonPrimes[j*i] = true;
                }
            }
        }
        return count;
    }
}