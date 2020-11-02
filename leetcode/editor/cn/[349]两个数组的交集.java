//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 245 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            int judge = Integer.compare(nums1[i], nums2[j]);
            switch (judge) {
                case -1:
                    ++i;
                    break;
                case 1:
                    ++j;
                    break;
                case 0:
                    set.add(nums1[i]);
                    ++i;
                    ++j;
                    break;
                default:
            }
        }
        Integer[] ints = set.toArray(new Integer[1]);
        if (ints[0] == null) {
            return new int[0];
        }
        int[] ret = new int[ints.length];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = ints[i];
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
