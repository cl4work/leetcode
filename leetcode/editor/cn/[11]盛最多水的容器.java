//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1872 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int maxArea(int[] height) {
//
//        int maxArea = -1;
//        int area = -1;
//        for (int i = 0;i < height.length - 1;i++) {
//
//            for (int j = i + 1;j < height.length; j++) {
//
//                area = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
//                if (area > maxArea) {
//                    maxArea = area;
//                }
//
//            }
//
//        }
//        return maxArea;
//
//    }
//}

class Solution {
    private int firstPoint = 0;
    private int lastPoint = -1;

    public int maxArea(int[] height) {

        lastPoint = height.length - 1;
        int maxArea = -1;
        int area = -1;
        for (;firstPoint < lastPoint;) {

            if (height[firstPoint] < height[lastPoint]) {
                area = getArea(height[firstPoint]);
                firstPoint++;
            }else {
                area = getArea(height[lastPoint]);
                lastPoint--;
            }
            if (area > maxArea) {
                maxArea = area;
            }

        }
        return maxArea;

    }

    private int getArea(int high) {

        return (lastPoint - firstPoint) * high;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
