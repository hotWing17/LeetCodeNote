// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as you like 

// (i.e., buy one and sell one share of the stock multiple times).

// Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

//思路：依次后移，发现比前面大的就卖掉，并且加上挣的差值，依次进行
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 1;
        while(i < prices.length){
            if(prices[i] > prices[i-1]){
                maxProfit +=prices[i] - prices[i-1];
            }
            i++;
        }
        return maxProfit;
    }
}