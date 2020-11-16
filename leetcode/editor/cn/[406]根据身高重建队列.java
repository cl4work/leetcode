//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法 
// 👍 581 👎 0

import java.util.Arrays;

//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
//总人数少于1100人。
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[][] reconstructQueue(int[][] people) {

        //若身高不同，按身高排序，
        //若身高相同，由于越靠前越先被添加进答案，先添加靠后的人，再添加靠前的人，如此靠后的人的排名不会被靠前的人所干扰，
        //所以， 按排名降序排序
        Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));

        int arrayLength = people.length;
        int[][] sortedPeople = new int[arrayLength][];
        for (int[] person : people) {
            int count = 0;
            for (int j = 0; j < arrayLength; ++j) {
                if (sortedPeople[j] != null) {
                    continue;
                }
                if (count != person[1]) {
                    ++count;
                    continue;
                }
                sortedPeople[j] = Arrays.copyOf(person, 2);
                break;
            }
        }
        return sortedPeople;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
