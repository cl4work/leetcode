//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 249 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {

        char[] letters = s.toCharArray();
        int n = letters.length;
        int ret = 0;
        for (int i = 0; i < n; ) {
            int count = k;
            int length = -1;
            int nextIndex = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; ++j) {
                if (letters[j] == letters[i]) {
                    continue;
                }
                if (nextIndex == Integer.MAX_VALUE) {
                    nextIndex = j;
                }
                if (count > 0) {
                    --count;
                    continue;
                }
                length = j - i;
                break;
            }
            if (length == -1) {
                length = n - i;
            }
            if (count > 0) {
                length = Integer.min(n, length + count);
            }
            ret = Integer.max(ret, length);
            i = nextIndex;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
