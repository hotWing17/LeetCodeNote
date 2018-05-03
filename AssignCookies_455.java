class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //被满足的小孩的最大值
        int maxContent = 0;
        int gPoint = 0;
        int sPoint = 0;

        //将两个数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);

        while((gPoint < g.length) && (sPoint < s.length)){
            if(s[sPoint] >= g[gPoint]){
                maxContent++;
                gPoint++;
                sPoint++;
                continue;
            }
            else{
                sPoint++;
            }
        }
        return maxContent;
    }
}