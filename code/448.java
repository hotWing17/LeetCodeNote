// 448. 找到所有数组中消失的数字Find All Numbers Disappeared in an Array

// 方法一：思路：
// 没有使用额外的空间，但是时间效率不是特别高
// 第一层循环遍历数组，拿到数字之后，
// 进行第二层循环，减1之后作为下标，去到对应的位置，先存起来目标位置的数字为tmp， 之后该位置标-1
// 一次进行，知道数组遍历完毕，最后从头遍历一次数组，没有标-1的位置下标+1则为所求数字。
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int p = 0;
        
        int test = 0;
        List<Integer> list = new LinkedList<Integer>();
        for(p = 0; p < nums.length; p++){
            if(nums[p] != -1){
                int tmp = nums[p];
                while(tmp != -1){
                    test = tmp;
                    tmp = nums[test - 1];
                    nums[test - 1] = -1;

                }
            }
        }

        for(p = 0; p < nums.length; p++){
            if(nums[p] != -1){
                list.add(p+1);
            }
        }

        return list;

    }
}


// 方法二：思路：
// 使用一个数组记录出现过的数字，最后遍历一次数组，没有标记的则为没有出现过的数字。
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        int[] count = new int[nums.length+1];
        for(int n : nums)
            count[n]++;
        for(int i = 1; i < count.length; i++)
            if(count[i] == 0)
                list.add(i);
        return list;
    }
}