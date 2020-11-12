//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 134 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 输入：[4,2,5,7]
//输出：[4,5,2,7]
// 2 <= A.length <= 20000
// A.length % 2 == 0
// 0 <= A[i] <= 1000
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParityII(int[] A) {


        int[] a1 = Arrays.stream(A).filter(a -> (a & 1) == 0).toArray();
        int[] a2 = Arrays.stream(A).filter(a -> (a & 1) == 1).toArray();
        int[] result = new int[A.length];
        int index = 0;
        for(int i = 0; i < a1.length; ++i) {
            result[index++] = a1[i];
            result[index++] = a2[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
