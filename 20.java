class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                list.push(c);
            }else if(list.isEmpty() || list.pop() != map.get(c)){
                return false;
            }
        }
        return list.isEmpty();
    }
}