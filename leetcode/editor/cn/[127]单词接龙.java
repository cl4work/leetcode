//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 502 👎 0


import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        boolean[] usedWords = new boolean[wordList.size()];
        boolean exitEndWord = false;
        int indexEndWord = -1;
        for (String word : wordList) {
            if (compareString(endWord, word) == 0) {
                exitEndWord = true;
                indexEndWord = wordList.indexOf(word);
                break;
            }
        }
        if (!exitEndWord) {
            return 0;
        }
        int count = 0;
        Set<String> strings = new HashSet<>();
        strings.add(beginWord);
        while (strings.size() != 0) {
            Set<String> newStrings = new HashSet<>();
            for (String string : strings) {
                int index = 0;
                for (String word : wordList) {
                    if (compareString(string, word) == 1 && !usedWords[index]) {
                        newStrings.add(word);
                        usedWords[index] = true;
                    }
                    ++index;
            }
            }
            count++;
            if (usedWords[indexEndWord]) {
                return count + 1;
            }
            strings = newStrings;
        }
        return 0;
    }

    private int compareString(String string01, String string02) {
        char[] string01s = string01.toCharArray();
        char[] string02s = string02.toCharArray();
        int count = 0;
        for (int i = 0; i < string01s.length; ++i) {
            if (string01s[i] != string02s[i]) {
                ++count;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
