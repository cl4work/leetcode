//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 91 👎 0

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// arr2 中的元素 arr2[i] 各不相同
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int NUM_RANGE = 1000;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] nums = countNums(arr1);
        return addElement(arr1, arr2, nums);
    }

    private int[] addElement(int[] arr1, int[] arr2, int[] nums) {

        int[] result = new int[arr1.length];
        int index = 0;
        for (int num : arr2) {
            for (int i = 0; i < nums[num]; ++i) {
                result[index++] = num;
            }
            nums[num] = 0;
        }
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums[i]; ++j) {
                result[index++] = i;
            }
        }
        return result;
    }


    private int[] countNums(int[] arr1) {

        int[] nums = new int[NUM_RANGE + 1];
        for (int num : arr1) {
            ++nums[num];
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
