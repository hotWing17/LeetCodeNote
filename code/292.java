// 292. Nim游戏 Nim Game
// 思路：从数据中发现为4的倍数时，你不可能赢得比赛，所以求4的倍数
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}