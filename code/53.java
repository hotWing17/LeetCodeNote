//53. 最大子序和(动态规划)


/*
 * 思路一：动态规划(O(lgN))
 * dp[i]：以"i"做结尾的连续子数组的最大值
 * 在“i”处，由于题目要求时“连续子数组”，所以对于nums[i]只有以下两种选择：
 * 1.加入前面的最长子数组
 * 2.放弃前面的子数组，单独从nums[i]开始作为最长子数组
 */
class Solution {
    public int maxSubArray(int[] nums) {
        
        //if(nums.length == 0)return 0; //貌似测试用例没有使用空数组，可去掉提升速度，但是代码鲁棒性不完整

        int[] dp = new int[nums.length];            //dp[i]存储的值表示以"i"做结尾的连续子数组的最大值
        dp[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++){

            //1.当前字符 大于 dp[i-1]加上当前字符，则dp[i]表示最大子序只有当前字符
            //2.当前字符 小于 dp[i-1]加上当前字符，则dp[i]表示最大子序为dp[i-1]的最长子序加上当前字符
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            //dp[i] = dp[i - 1]>0?dp[i - 1] + nums[i]:nums[i];      //上面的式子转换成这个语句，效果是等价的
            if(max < dp[i])max = dp[i];
        }
        return max;
    }
}



/*
 * 思路二：分治法
 * 分治法的思路，即求出nums[0...i]这个子数组区间的最大子序和
 * 循环遍历，加入新的元素nums[i],将当前记录的(nums[0...i-1])区间最大的子序和------->maxFar
 * 和 以新加入的nums[i]元素结尾的最大子序和----->maxHere    进行比较
 * 
 * 
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
        //if(nums.length == 0) return 0;//貌似测试用例没有使用空数组，可去掉提升速度，但是代码鲁棒性不完整
        
        int maxFar = nums[0];       //记录 nums[0...i] 这些数字区间最大的子序和
        int maxHere = 0;            //记录以 nums[i] 为结尾的最大子序和
        
        for(int i = 0 ; i < nums.length; i++) {
            maxHere += nums[i];
            if(maxHere > maxFar) maxFar = maxHere;

            //“以 nums[i] 为结尾的最大子序和”小于0，则重置为0，因为后一个nums[i+1]的maxHere应该为nums[i+1];
            if(maxHere < 0) maxHere = 0;        
        }
        return maxFar; 
    }
}