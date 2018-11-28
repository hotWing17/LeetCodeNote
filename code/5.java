//5. 最长回文子串
//使用动态规划的算法思想就行解题
//时间复杂度：O(n^2)
//空间复杂度：O(n^2)
class Solution {
    public String longestPalindrome(String s) {

        if(s.equals(""))return "";

        char[] M = s.toCharArray();
        boolean[][] dp = new boolean[M.length][M.length];

        int max = 1;
        int left = 0;
        int right = 0;

        //初始化一字母和二字母的回文
        for(int i = 0; i < M.length - 1; i++){
            dp[i][i] = true;
            if(M[i] == M[i+1]){
                dp[i][i+1] = true;
                left = i;
                right = i + 1;
                max = 2;
            }  
        }
        dp[M.length - 1][M.length - 1] = true;


        for(int j = 2; j < M.length; j++){
            for(int i = 0; i < j; i++){
                if(dp[i + 1][j - 1] && M[i] == M[j]){
                    dp[i][j] = true;
                    if(j-i+1 > max){left = i; right = j; max = j-i+1;}
                }
            }
        }
        return s.substring(left, right + 1);
    }
}

//参考其他人的算法
//中心扩展算法
//时间复杂度：O(n^2)
//空间复杂度：只需要固定的空间
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0)
        {
            return s;
        }
        int start = 0 ;
        int end = 0 ;
        for(int i = 0 ; i < s.length() ; i++)
        {
            int len1 = expand(s,i,i+1);
            int len2 = expand(s,i,i);
            int max = Math.max(len1,len2);
            if(max > end - start)
            {
                start = i-(max-1)/2;
                end = i+(max/2);
            }
        }
        return s.substring(start,end+1);
    }
    
    public int expand(String s , int start , int end)
    {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
        {
            start--;
            end++;
        }
        return end-start-1;
    }
}