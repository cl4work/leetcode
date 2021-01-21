//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 545 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        boolean needPlusOne = false;
        StringBuilder ret = new StringBuilder();
        while (indexA >= 0 || indexB >= 0) {
            int sum = needPlusOne ? 1 : 0;
            if (indexA >= 0) {
                sum +=  a.charAt(indexA--) - 48;
            }
            if (indexB >= 0) {
                sum += b.charAt(indexB--) - 48;
            }
            if (sum > 1) {
                needPlusOne = true;
                ret.insert(0, sum - 2);
            } else {
                needPlusOne = false;
                ret.insert(0 , sum);
            }
        }
        if (needPlusOne) {
            ret.insert(0, 1);
        }
        return ret.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
