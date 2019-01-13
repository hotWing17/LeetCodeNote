// 面试题4：二维数组中的查找


/**
 * 题目描述：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 */



// 方法一 ：暴力
public class Solution {
    public boolean Find(int target, int [][] array) {
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                if(array[i][j] == target)return true;
            }
        }
        return false;
    }
}

// 方法二 ：选择合适的位置开始判断，减少计算数据量
/**
 * 题目描述：从二维数组的右上角或者左下角开始判断，此时每次判断可以剔除当前行或者当前列，减少判断数据量
 * 
 * 思路：
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        // 从左下角开始进行判断
        int row = 0;
        int col = array[0].length - 1;

        while(row < array.length && col >= 0){
            if(target == array[row][col])return true;
            else if(target > array[row][col]){
                row++;
                continue;
            }else{
                col--;
                continue;
            }
        }
        return false;
    }
}