// 70. 爬楼梯
// 使用动态规划的思想
// dp[i] = d[i-1] + d[i-2]： dp[i]表示到达第"i"级阶梯一共有多少种方法
// 程序运行的时候，每个阶梯只需要获取到它的前一节和前两节阶梯的方法就行，所以本程序使用两个变量记录这两个值就好，不需要开数组
// 时间复杂度为O(n),空间复杂度为O(1)
class Solution {
    public int climbStairs(int n) {
        if(n == 1)return 1;
        if(n == 2)return 2;
        int i_2 = 1;
        int i_1 = 2;
        int tmp = 0;
        for(int i = 3; i <= n; i++){
            tmp = i_1 + i_2;
            i_2 = i_1;
            i_1 = tmp;
        }
        return i_1;
    }
}