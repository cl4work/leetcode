//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法 
// 👍 259 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<String> ret = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        Set<Character> set1 = new HashSet<>();
        for (char chara : chars) {
            set.add(chara);
        }
        for (String word : wordDict) {
            char[] chars1 = word.toCharArray();
            for (char chara : chars1) {
                set1.add(chara);
            }
        }
        for (char charisi : set) {
            if (!set1.contains(charisi)) {
                return ret;
            }
        }
        List<List<Integer>> indexListList = new ArrayList<>();
        do {
            indexListList = addIndexList(indexListList, wordDict, s);
        } while (indexListList.size() != 0);
        return ret;
    }

    private List<List<Integer>> addIndexList(List<List<Integer>> indexListList, List<String> wordDict, String s) {

        List<List<Integer>> newIndexListList = new ArrayList<>();
        for (String word : wordDict) {
            if (indexListList.size() == 0) {
                List<Integer> newIndex = addIndex(new ArrayList<Integer>(), word, s);
                if (newIndex != null) {
                    newIndexListList.add(newIndex);
                }
                continue;
            }
            for (List<Integer> indexList : indexListList) {
                List<Integer> preIndexList = new ArrayList<>(indexList);
                List<Integer> newIndex = addIndex(preIndexList, word, s);
                if (newIndex != null) {
                    newIndexListList.add(newIndex);
                }
            }
        }
        return newIndexListList;
    }

    private List<Integer> addIndex(List<Integer> indexList, String word, String s) {

        int index = (indexList.size() == 0) ? 0 : indexList.get(indexList.size() - 1);
        int endIndex = index + word.length();
        if (endIndex > s.length()) {
            return null;
        }
        if (word.equals(s.substring(index, endIndex))) {
            if (endIndex == s.length()) {
                addString(indexList, s);
                return null;
            }
            indexList.add(endIndex);
            return indexList;
        }
        return null;
    }

    private void addString(List<Integer> indexList, String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < indexList.size(); i++) {
            stringBuilder.insert(indexList.get(i) + i, " ");
        }
        ret.add(stringBuilder.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
