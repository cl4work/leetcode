//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 160 👎 0


import java.util.Map;
import java.util.TreeMap;

//输入: [1,3,2,3,1]
//输出: 2
// 给定数组的长度不会超过50000。
// 输入数组中的所有数字都在32位整数的表示范围内。
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int reversePairs(int[] nums) {
        Map<Long, Integer> numMap = new TreeMap<>();
        int result = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            long num = nums[i];
            for (Map.Entry<Long, Integer> entry : numMap.entrySet()) {
                if (num <= entry.getKey()) break;
                result += entry.getValue();
            }
            numMap.put(num * 2, numMap.getOrDefault(num * 2, 0) + 1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
