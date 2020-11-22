//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 295 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {

        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (char element : chars) ++counts[element - 97];
        chars = t.toCharArray();
        for (char element : chars) --counts[element - 97];
        for (int element : counts) if (element != 0) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
