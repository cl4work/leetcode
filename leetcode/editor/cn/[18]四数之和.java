//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
// 注意：
//
// 答案中不可以包含重复的四元组。
//
// 示例：
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
// Related Topics 数组 哈希表 双指针
// 👍 615 👎 0
//
//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> fourSum = new ArrayList<>();
        Map<Integer,List<List<Integer>>> plusMap = new HashMap<>();
        boolean isRepeated = false;
        int temp = 0;
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0;i < nums.length - 1;i++) {

            for (int j = i + 1;j < nums.length;j++) {


                if (!plusMap.containsKey(nums[i] + nums[j])) {
                    List<List<Integer>> value = new ArrayList<>();
                    value.add(new ArrayList<Integer>(Arrays.asList(i,j)));
                    plusMap.put(nums[i]+nums[j],value);
                    continue;
                } else if (!isRepeated) {
                    List<List<Integer>> value = plusMap.get(nums[i] + nums[j]);
                    List<Integer> newElement01 = new ArrayList<Integer>(Arrays.asList(i,j));
                    List<Integer> newElement02 = new ArrayList<Integer>(Arrays.asList(j,i));
                    if (!value.contains(newElement01) && !value.contains(newElement02)) {
                        value.add(newElement01);
                        plusMap.put(nums[i]+nums[j],value);
                    }
                }

            }

        }
        for (int i=0;i<nums.length-1;i++) {
            for (int j= i+1;j<nums.length;j++) {
                temp = target - nums[i] - nums[j];
                if (plusMap.containsKey(temp)) {

                    List<List<Integer>> tempListList = plusMap.get(temp);
                    for (int k = 0; k < tempListList.size(); k++) {

                        tempList = tempListList.get(k);



                        if (tempList.get(1) != j && tempList.get(1) != i && tempList.get(0) != i && tempList.get(0) != j) {
                            int[] ints = {nums[tempList.get(0)], nums[tempList.get(1)], nums[i], nums[j]};
                            Arrays.sort(ints);
                            List<Integer> sortedList = Arrays.asList(ints[0], ints[1], ints[2], ints[3]);
                            if (!fourSum.contains(sortedList)) {
                                fourSum.add(sortedList);
                            }
                        }

                    }
                }

            }
        }
        return fourSum;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
