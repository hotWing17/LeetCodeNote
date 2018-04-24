// 通过，运行时间不理想
// 方法一
class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length-1, nums, target);
    }
    public int binarySearch(int head, int tail, int[] nums, int target){
        if(head == tail){
            if(target <= nums[head])return head;
            else return head+1;
        }
        else{
            int mid = (head + tail)>>>1;
            if(target < nums[mid])return binarySearch(head, mid, nums, target);
            else if(target > nums[mid])return binarySearch(mid+1, tail, nums, target);
            else return mid;
        }
    }
}

// 参考的较好方法
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (right-left)/2+left;
            if (nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left; 
    }
}