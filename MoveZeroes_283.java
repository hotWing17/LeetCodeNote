class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int temp = 0;
        while(j < nums.length){
            if(nums[i] == 0){
                while(j < nums.length && nums[j] == 0){
                    j++;
                }
                if(j == nums.length){break;}
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j = i + 1;
            }else{i++;j = i + 1;}
        }
    }
}

//网上参考
/*
class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZero] = nums[i];
                lastNonZero++;
            }
        }
        for(int j = lastNonZero; j < nums.length; j++){
            nums[j] = 0;
        }
    }
}
*/