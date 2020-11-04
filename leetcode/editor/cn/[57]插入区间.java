//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
//[[1,2],[3,5],[6,7],[8,10],[12,16]]
//[4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。 
// Related Topics 排序 数组 
// 👍 226 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int nullCount;

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] newIntervals = insertNewInterval(intervals, newInterval);
        return rearrangeInterval(newIntervals, newInterval);
    }

    private int[][] rearrangeInterval(int[][] intervals, int[] newInterval) {

        int[][] newIntervals = new int[intervals.length - nullCount][2];
        int index = 0;
        boolean inserted = false;
        for (int[] interval : intervals) {
            if (!inserted && nullCount == -1 && interval[0] > newInterval[1]) {
                newIntervals[index++] = newInterval;
                inserted = true;
            }
            if (interval != null) {
                newIntervals[index++] = interval;
            }
        }
        if (!inserted && nullCount == -1) {
            newIntervals[index] = newInterval;
        }
        return newIntervals;
    }

    private int[][] cloneIntInt(int[][] intervals) {
        int[][] newIntervals = new int[intervals.length][2];
        for (int i = 0; i < newIntervals.length; ++i) {
            for (int j = 0; j < 2; ++j) {
                newIntervals[i][j] = intervals[i][j];
            }
        }
        return newIntervals;
    }

    private int[][] insertNewInterval(int[][] intervals, int[] newInterval) {

        intervals = cloneIntInt(intervals);
        boolean addNew = true;
        for (int i = 0; i < intervals.length; ++i) {
            if (intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Integer.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Integer.max(intervals[i][1], newInterval[1]);
                if (addNew) {
                    intervals[i] = newInterval;
                    addNew = false;
                } else {
                    intervals[i] = null;
                    nullCount++;
                }
            }
        }
        if (addNew) {
            nullCount = -1;
        }
        return intervals;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
