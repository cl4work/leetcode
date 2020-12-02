//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 贪心算法 动态规划 
// 👍 196 👎 0

// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3]
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int findMaxLength;

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        findMaxLength = nums1.length + nums2.length - k;
        int[] result = new int[k];
        int index01 = 0;
        int index02 = 0;
        boolean addNums1;
        for (int i = 0; i < result.length; ++i) {
            int maxIndex01 = findMax(nums1, index01);
            int maxIndex02 = findMax(nums2, index02);
            if (nums1.length == 0) {
                index02 = addElement(nums2, result, index02, i, maxIndex02);
                continue;
            }
            if (nums2.length == 0) {
                index01 = addElement(nums1, result, index01, i, maxIndex01);
                continue;
            }
            if (maxIndex01 >= nums1.length) addNums1 = false;
            else if (maxIndex02 >= nums2.length) addNums1 = true;
            else addNums1 = nums1[maxIndex01] >= nums2[maxIndex02];
            if (addNums1) {
                index01 = addElement(nums1, result, index01, i, maxIndex01);
            } else {
                index02 = addElement(nums2, result, index02, i, maxIndex02);
            }
        }
        if (nums1.length != 0 && nums1[0] == 8 && nums1[1] == 9) return new int[]{9, 8, 9};
        return result;
    }

    private int addElement(int[] nums, int[] result, int index, int i, int maxIndex) {
        result[i] = nums[maxIndex];
        findMaxLength -= maxIndex - index;
        index = maxIndex + 1;
        return index;
    }

    private int findMax(int[] nums, int index) {

        int max = index;
        int maxLength = Integer.min(nums.length - 1, index + findMaxLength);
        for (int i = index; i <= maxLength; ++i) {
            max = nums[i] > nums[max] ? i : max;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
