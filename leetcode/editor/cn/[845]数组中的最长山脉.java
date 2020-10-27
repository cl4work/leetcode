//我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： 
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 96 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestMountain(int[] A) {

        if (A.length < 3) {
            return 0;
        }
        int max = 0;
        int length = 0;
        boolean isMountain = false;
        for (int i = 0, j = 2; j < A.length; i++, j++) {
            int descLeft = Integer.compare(A[i], A[j - 1]);
            int descRight = Integer.compare(A[j - 1], A[j]);
            if (i == 0 && descLeft == -1 && descRight != 0) {
                isMountain = true;
                length = 2;
            }
            switch (descLeft) {
                case 1:
                    switch (descRight) {
                        case 1:
                            if (isMountain) {
                                length++;
                            }
                            break;
                        case 0:
                            if (isMountain) {
                                isMountain = false;
                                max = Math.max(max, length);
                            }
                            break;
                        case -1:
                                max = Math.max(max, length);
                                isMountain = true;
                                length = 2;
                            break;
                    }
                    break;
                case 0:
                    switch (descRight) {
                        case 1:
                        case 0:
                            break;
                        case -1:
                            isMountain = true;
                            length = 2;
                            break;
                    }
                    break;
                case -1:
                    switch (descRight) {
                        case 1:
                            if (isMountain) {
                                length++;
                            }
                            break;
                        case 0:
                            if (isMountain) {
                                isMountain = false;
                            }
                            break;
                        case -1:
                            if (isMountain) {
                                length++;
                            } else {
                            }
                            break;
                    }
                    break;
            }
            if (j == A.length - 1 && isMountain && descRight == 1) {
                max = Math.max(max, length);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
