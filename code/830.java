//自己整理优化代码
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        
        int i = 0;          //这个更加的通用，从 i=0 开始循环
        char temp = '-';
        int count = 0;
        int start = 0;
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        while(i < S.length()){
            if(temp == S.charAt(i)){
                count++;
                i++;
                continue;}
            else if(count > 2){
                List<Integer> list = new LinkedList<Integer>();
                list.add(start);
                list.add(i - 1);
                result.add(list);
            }
            temp = S.charAt(i);     //比之前简略了一些代码
            count = 1;
            start = i;
            i++;
        }

        if(count > 2){              //最后一个循环结束时，还要再判断一次最后一个串是否满足条件
            List<Integer> list = new LinkedList<Integer>();
            list.add(start);
            list.add(i - 1);
            result.add(list);
        }

        return result;
    }
}