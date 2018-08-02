class Solution {
    //自己完成
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int head = 0, tail = numbers.length - 1;
        int temp = 0;
        int p = 0;
        for(head = 0; head < tail; head++){
            p = head + 1;
            while(p <= tail)
            {
                temp = numbers[head] + numbers[p];
                if(temp < target)p++;
                else if(temp > target) {tail = p; break;}
                else{
                    result[0] = head + 1;
                    result[1] = p + 1;
                    return result;
                }
            }
        }
        return null;
    }

    //网上参考
    // public int[] twoSum(int[] nums, int target) {
    //     int l=0, r=nums.length-1;
    //     while(l<r){
    //         int sum=nums[l]+nums[r];
    //         if(sum==target){
    //             return new int[]{l+1, r+1};
    //         }else if(sum<target){
    //             l++;
    //         }else{
    //             r--;
    //         }
    //     }
    //     return new int[]{0,0};
    // }
}