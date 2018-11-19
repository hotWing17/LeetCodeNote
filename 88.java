//思路：尝试，比较大的，从末尾开始放置
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int i = 0;
        for(i = m+n-1; p>=0 && q>=0; i--){
            if(nums1[p] > nums2[q]){nums1[i] = nums1[p]; p--;}
            else{nums1[i] = nums2[q]; q--;}
        }
        if(p == -1){
            while(q >= 0){
                nums1[i] = nums2[q];
                i--;q--;
            }
        }
    }
}