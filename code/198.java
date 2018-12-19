//198. 打家劫舍

//动态规划算法
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return nums[0] > nums[1] ? nums[0] : nums[1];
        if(nums.length == 3)return Math.max(nums[0] + nums[2], nums[1]);
        int i_3 = nums[0];
        int i_2 = nums[1];
        int i_1 = nums[2] + nums[0];
        int tmp = 0;
        
        for(int i = 3; i < nums.length; i++){       //tips:还需要判断 i-2 和 i-3哪一个比较大，选择较大的那个金额
            tmp = Math.max(i_3, i_2) + nums[i];     //tmp ：表示以第i个房子作为最后一个打劫目标，能获取到的最大的金额
            i_3 = i_2;
            i_2 = i_1;
            i_1 = tmp;
        }

        return i_1 > i_2 ? i_1 : i_2;
    }
}

//动态规划算法(优化，代码简洁)
/* 思路：
 * 循环遍历每一个房子nums[i]，每次比较打劫或者是不打劫 第nums[i]个房子能获取到的最大金额
 *
 */
class Solution {
    public int rob(int[] nums) {

        //虽然不加上这两个判断，以下的程序就可以完成所有的测试，但是加上判断，可以让程序少做无谓的循环，提高一点点点点效率
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];

        int rob = 0, notRob = 0;
        for(int i=0; i<nums.length; i++){       //每遍历一个结点，如nums[i]，表示一共有[0...i]个房子给予你打劫，
            int tmp = nums[i] + notRob;         //而这种时候应该分为两种情况，打劫或者不打劫第i个房子
            
            notRob = Math.max(rob, notRob);
            rob = tmp;
        }
        return Math.max(rob, notRob);
    }
}