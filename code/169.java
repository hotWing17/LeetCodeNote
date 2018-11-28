class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1)return nums[0];
        int temp = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == temp)count++;
            else if(count == 1){temp = nums[i+1];i++;}
            else count--;
        }
        return temp;
    }
}