//视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。 
//
// 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。 
//
// 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，
//以此逐个拼写完 key 中的所有字符。 
//
// 旋转 ring 拼出 key 字符 key[i] 的阶段中： 
//
// 
// 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符
// key[i] 。 
// 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段
//）, 直至完成所有拼写。 
// 
//
// 示例： 
//
// 
//
//
// 
//
// 输入: ring = "godding", key = "gd"
//输出: 4
//解释:
// 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
// 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
// 当然, 我们还需要1步进行拼写。
// 因此最终的输出是 4。
// 
//
// 提示： 
//
// 
// ring 和 key 的字符串长度取值范围均为 1 至 100； 
// 两个字符串中都只有小写字符，并且均可能存在重复字符； 
// 字符串 key 一定可以由字符串 ring 旋转拼出。 
// Related Topics 深度优先搜索 分治算法 动态规划 
// 👍 77 👎 0

import java.util.*;

// 输入: ring = "godding", key = "gd"
//输出: 4
// ring 和 key 的字符串长度取值范围均为 1 至 100；
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static final int KEY_MAX_RANGE = 10000;

    public int findRotateSteps(String ring, String key) {

        Map<Integer, Integer> abilityMap = new HashMap<>();
        abilityMap.put(0, 0);
        for (int i = 0; i < key.length(); ++i) {
            if (i != 0 && key.charAt(i - 1) == key.charAt(i)) {
                continue;
            }
            abilityMap = addAbilityMap(abilityMap, ring, key, i);
        }
        return getMin(abilityMap) + key.length();
    }

    private int getMin(Map<Integer, Integer> abilityMap) {

        int result = Integer.MAX_VALUE - KEY_MAX_RANGE;
        for (int element : abilityMap.values()) {
            result = Math.min(result, element);
        }
        return result;
    }

    private Map<Integer, Integer> addAbilityMap(Map<Integer, Integer> abilityMap, String ring, String key, int i) {

        Map<Integer, Integer> newAbilityMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : abilityMap.entrySet()) {
            int index = entry.getKey();
            int count = entry.getValue();
            if (ring.charAt(index) == key.charAt(i)) {
                addEntry(newAbilityMap, index, count);
                continue;
            }
            int right = index;
            int left = index;
            do {
                right = (++right == ring.length()) ? 0 : right;
                left = (--left == -1) ? ring.length() - 1 : left;
                ++count;
                if (ring.charAt(left) == key.charAt(i)) {
                    addEntry(newAbilityMap, left, count);
                }
                if (ring.charAt(right) == key.charAt(i)) {
                    addEntry(newAbilityMap, right, count);
                }
            } while (right != left);
        }
        return newAbilityMap;
    }

    private void addEntry(Map<Integer, Integer> newAbilityMap, int index, int count) {

        newAbilityMap.put(index,
                Math.min(
                        newAbilityMap.getOrDefault(index, Integer.MAX_VALUE), count));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
