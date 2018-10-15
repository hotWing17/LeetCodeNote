class Solution {
    public int romanToInt(String s) {
        char []S = s.toCharArray();
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        

        int i = 0;
        int j = 1;
        int result = 0;
        int iNum = 0;
        int jNum = 0;

        while(j < S.length){
        	char cI = S[i];
        	char cJ = S[j];
            iNum = map.get(cI);
            jNum = map.get(cJ);
            if(iNum < jNum){
                result += jNum - iNum;
                i += 2;
                j += 2;
            }else{
                result += iNum;
                i++;
                j++;
            }
        }
        if( i < S.length){
            result += map.get(S[i]);
        }
        
        return result;
    }
}


//参考较快的方法
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> mapping = new HashMap<>();
        
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
        
        int res = 0;
        for (char c : s.toCharArray()) {
            res += mapping.get(c);
        }
        
        if (s.indexOf("IV") != -1 || s.indexOf("IX") != -1) {
            res -= 2;
        }
        if (s.indexOf("XL") != -1 || s.indexOf("XC") != -1) {
            res -= 20;
        }
        if (s.indexOf("CD") != -1 || s.indexOf("CM") != -1) {
            res -= 200;
        }
        
        return res;
    }
}