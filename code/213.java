// 213. 打家劫舍 II
// 思路与 198题目相似，唯一的区别在于第一个房子的打劫与否
// 在原本打劫房子题目的基础上，需要分为两种情况
// 1、打劫第一个房子，那么最后一个房子不能打劫，因为最后一个房子和第一个房子相邻，会报警
// 2、不打劫第一个房子，那么最后一个房子可以打劫
class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];

        //第一种情况：打劫第一个房子(代表最后一个房子不可以打劫)
        int robFirst = robFromWhere(nums, 0, nums.length - 1);

        //第二种情况：不打劫第一个房子(代表最后一个房子可以打劫)
        int notRobFirst = robFromWhere(nums, 1, nums.length);

        return Math.max(robFirst, notRobFirst);
    }

    //本函数作用：得到 从第nums[start]房子开始，到nums[end-1]这个房子结束，抢劫到的最大金额
    public int robFromWhere(int[] nums, int start, int end){
        int rob = 0, notRob = 0;
        int tmp = 0;
        for(int i=start; i<end; i++){       //每遍历一个结点，如nums[i]，表示一共有[start...i]个房子给予你打劫，
            tmp = nums[i] + notRob;         //而这种时候应该分为两种情况，打劫或者不打劫第i个房子
            notRob = Math.max(rob, notRob);
            rob = tmp;
        }
        return Math.max(rob, notRob);
    }
}