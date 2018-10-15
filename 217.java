// Given an array of integers, find if the array contains any duplicates. 
// Your function should return true if any value appears at least twice in the array, 
// and it should return false if every element is distinct.

// 思路：
// 1、先把数组排序，然后遍历，查看前后两个元素是否相等
import java.util.Arrays;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1;i < nums.length;i++,p++){
            if(nums[i] == nums[i-1])return true;
        }
        return false;
    }
}