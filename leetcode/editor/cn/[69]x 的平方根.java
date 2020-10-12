//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 511 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//
//两种选择：
//1.指定初始最大最小值，使计算需要的内存扩大，但省去计算范围的时间
//2.通过计算初始化一个合适的范围，是的计算需要的内存降低，但增加了计算的时间
class Solution {
    private int max = 10;
    private int min = 1;
    private int mid = 5;
    boolean isInited = false;
    public int mySqrt(int x) {

        if (!isInited) {

            if (x == 0) {
                return 0;
            }
            init(x);
            isInited = true;

        }
        mid = (max + min) / 2;
        if (max == mid || min == mid) {
            return mid;
        }


        if (x == max*max) {
            return max;
        }else if (x == min*min) {
            return min;
        }

        if (x < mid*mid) {
            max = mid;
        }else {
            min = mid;
        }
        return mySqrt(x);

    }

    private void init(int x) {

        boolean needMultTen = false;
        for(x /= 10;x > 0;x /= 10) {
            if (needMultTen) {
                max *= 10;
                min *= 10;
            }
            if (max > 46341) {
                max = 46341;
            }
            needMultTen = !needMultTen;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
