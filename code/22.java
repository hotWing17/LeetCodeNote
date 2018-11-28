//错误
class Solution {
    public List<String> generateParenthesis(int n) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("()", null);
        Map<String, Object> result = new HashMap<String, Object>();

        int i = 0;  //计数
        while(i < n-1){
            result = new HashMap<String, Object>();
            for(String s : map.keySet()){
                result.put("("+ s + ")", null);
                result.put(s + "()", null);
                result.put("()"+ s, null);
            }
            map = result;
            result = null;
            i++;
        }

        List<String> list = new LinkedList<String>();
        if(n == 1){
            list.add("()");
            return list;
        }
        for(String s : map.keySet()){list.add(s);}

        return list;
        
    }
}



//二
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}


