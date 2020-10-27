//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 140 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] A) {

        if (A == null || A.length == 1) {
            return null;
        }
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        boolean isFirst = true;
        boolean addl2 = false;
        for (String a : A) {
            char[] cs = a.toCharArray();
            for (Character c : cs) {
                if (isFirst) {
                    l1.add(c.toString());
                } else {
                    if (addl2) {
                        if (l1.contains(c.toString())) {
                            l2.add(c.toString());
                            l1.remove(c.toString());
                        }
                    } else {
                        if (l2.contains(c.toString())) {
                            l1.add(c.toString());
                            l2.remove(c.toString());
                        }
                    }
                }
            }
            isFirst = false;
            if (addl2) {
                l1.clear();
            } else {
                l2.clear();
            }
            addl2 = !addl2;
        }
        if (addl2) {
            return l1;
        } else {
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
