//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。 
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 
// 👍 93 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> listA = reserveToList(A);
        List<Integer> listK = reserveToList(K);
        List<Integer> listSum = sum(listA, listK);
        return reserveToList(listSum);
    }

    private List<Integer> reserveToList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list);
        Collections.reverse(newList);
        return newList;
    }

    private List<Integer> reserveToList(int number) {
        List<Integer> list = new ArrayList<>();
        char[] chars = String.valueOf(number).toCharArray();
        for (int i = chars.length - 1; i >= 0; --i) {
            list.add(chars[i] - 48);
        }
        return list;
    }

    private List<Integer> reserveToList(int[] ints) {
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        return reserveToList(list);
    }

    private List<Integer> sum(List<Integer> A, List<Integer> B) {
        List<Integer> sum = new ArrayList<>();
        boolean needPlusOne = false;
        int index = 0, n = A.size(), m = B.size();
        while (index < Integer.max(n, m)) {
            int temp = needPlusOne ? 1 : 0;
            if (index < n) {
                temp += A.get(index);
            }
            if (index < m) {
                temp += B.get(index);
            }
            if (temp >= 10) {
                temp -= 10;
                needPlusOne = true;
            } else {
                needPlusOne = false;
            }
            sum.add(temp);
            ++index;
        }
        if (needPlusOne) {
            sum.add(1);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
