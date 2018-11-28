//3. 无重复字符的最长子串
class Solution {
    public int lengthOfLongestSubstring(String s) {


        if(s.length() == 0)return 0;
        
        char[] M = s.toCharArray();     //将字符串转换为字符数组
        int[] A = new int[256];         //用来记录对应字符的最后一次出现的位置
        A[M[0]] = 1;                    //找到第一个字符的映射地址，填入它的最后一次出现的位置"1"(注意：从"1"开始算起)
        int left = 1;                   //记录当前子串的起始位置(注意：从"1"开始算起)
        int tmp = 1;                    //记录当前子串的长度
        int result = 1;                 //记录最长无重复字符的长度


        for(int i = 1; i < M.length; i++){
            if(A[M[i]] < left){          //在当前滑动窗口没有重复
                result = Math.max(result, ++tmp);
            }
            else{                       //在当前滑动窗口重复
                left = A[M[i]];
                tmp = i - left + 1;
            }
            A[M[i]] = i + 1;            //更新当前遍历到的字符的“最后一次出现的位置”(注意：从"1"开始算起，所以需要“+1”)
        }
        return result;
    }
}