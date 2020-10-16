//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 131 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] A) {

        int temp = 0;
        int[] B = new int[A.length];
        int index = A.length-1;
        for (int i=0,j = A.length - 1; i<=j;) {
            if(i == j ){
                B[0] = A[i] *A[i];
                break;
            }
            if (-A[i]  > A[j]) {
                B[index] = A[i] * A[i];
                index--;
                i++;
                continue;
            }
            B[index] = A[j] * A[j];
            index--;
            j--;
        }
        return B;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
