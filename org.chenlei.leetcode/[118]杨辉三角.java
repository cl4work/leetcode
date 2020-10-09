//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 359 👎 0

//不用迭代也能做
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> temp = new ArrayList<Integer>(Arrays.asList(1));
    public List<List<Integer>> generate(int numRows) {

        if (numRows == 0) {
            return result;
        }
        if (numRows == 1) {
            result.add(temp);
            return result;
        }
        //recursion
        List<List<Integer>> oldListList = generate(numRows - 1);
        List<Integer> oldRows = oldListList.get(numRows - 2);
        List<Integer> newRows = new ArrayList<Integer>();
        //plus
        for (int i = 0; i < numRows; i++) {

            if (i == 0) {
                newRows.add(1);
            } else if (i == numRows -1) {
                newRows.add(1);
            } else {
                newRows.add(oldRows.get(i - 1) + oldRows.get(i));
            }

        }
        oldListList.add(newRows);
        return oldListList;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
