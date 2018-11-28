// 自己完成速度较慢
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")return 0;
        char p = 0;
        char q = needle.charAt(0);
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            p = haystack.charAt(i);
            if(p == q){
                String s = "";
                for(int j = i; j < needle.length() + i; j++){
                    s += haystack.charAt(j);
                }
                if(s.equals(needle))return i;
            }
        }
        return -1;
    }
}

//参考其他人的代码(优化)

class Solution {
    public int strStr(String haystack, String needle) {
        //排除空字符串的情况
        if (needle.equals("")) return 0;

        //找到首字符相同的位置指针
        for (int i = 0; i < haystack.length() - needle.length() +1; i++)
        {
            if (startWith(haystack, needle, i))
                return i;
        }
        return -1;        
    }
              
    //判断从该指针开始的字符串是否与目标字符串相同     
    boolean startWith(String s1, String s2, int i){
        for (int j = i; j < i + s2.length(); j++)
        {
            if (s1.charAt(j) != s2.charAt(j-i))
                return false;
        }
        return true;  
    }
              
}