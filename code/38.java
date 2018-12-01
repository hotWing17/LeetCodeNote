//*Count and Say* (报数)

//递归方法

// 思路：
// 使用递归的方法，第i个结果依赖于前一个结果
// 遍历上一个得到的结果，两个标记，一个记录符号(lastChar)，一个记录出现次数
// 当出现新的符号时，则将上一次的统计结果写入字符缓冲变量
class Solution {
    public String countAndSay(int n) {
        if(n == 1)return "1";
        String res = countAndSay(n-1);
        char[] M = res.toCharArray();

        char lastChar = M[0];
        int counter = 1;
        StringBuffer result = new StringBuffer();
        for(int i = 1; i < M.length; i++){
            if(M[i] == lastChar)counter++;
            else{
                result.append(counter);
                result.append(lastChar);
                lastChar = M[i];
                counter = 1;
            }
        }
        result.append(counter);
        result.append(lastChar);
        return result.toString();
    }
}