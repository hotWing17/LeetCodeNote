//136. 只出现一次的数字Single Number


// HashMap方法
// 思路：
// 维护一个HashMap，遍历数组，判断遍历到的元素是否在HashMap中存在，
// 不存在则存入HashMap，存在则从HashMap中去掉这个元素
// 当遍历完数组之后，HashMap中只剩一下 "只出现一次"的元素，取出返回
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        for(i=0; i < nums.length; i++){
            if(map.containsKey(nums[i]))map.remove(nums[i]);    //遍历数组，判断遍历到的元素是否在HashMap中存在，
            else map.put(nums[i], 1);                           //不存在则存入HashMap，存在则从HashMap中去掉这个元素
        }
        Iterator<Integer> it = map.keySet().iterator();
        return it.next();
    }
}

// 异或方法
// 思路：
// “异或”特性：因为 a^a = 0， a^0 = a;   所以 a^b^a = (a^a)^b = b
// 只需要将数组中所有元素进行异或运算，最后结果就是只出现一次的数字。
class Solution {
    public int singleNumber(int[] nums) {
        int i = 0;
        int res = 0;
        while(i < nums.length){
            res = res ^ nums[i++];
        }
        return res;
    }
}