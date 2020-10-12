//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 169 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//这种算法最多支持2层，3层会出现问题
class Solution {

    public int minDistance = 100000;

    public int getMinimumDifference(TreeNode root) {

        return getMinimumDifference(root, 0);

    }

    public int getMinimumDifference(TreeNode root, int isLeftNode) {

        //若为叶节点，返回值
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int rightMin = 10000000;
        int leftMax = -100000;
        int distance = 100000;
        //迭代，确认右节点的最小值，计算距离
        if (root.right != null) {
            rightMin = getMinimumDifference(root.right, -1);
            distance = rightMin - root.val;
        } else {
            rightMin = root.val;
        }
        if (distance > 0) {
            minDistance = minDistance < distance ? minDistance : distance;
        }

        //迭代，确认左节点的最大值，计算距离
        if (root.left != null) {
            leftMax = getMinimumDifference(root.left, 1);
            distance = root.val - leftMax;
        } else {
            leftMax = root.val;
        }
        if (distance > 0) {
            minDistance = minDistance < distance ? minDistance : distance;
        }

        //若为父节点的左节点，返回右节点返回的值
        //若为父节点的左节点，返回右节点
        //若为根节点，返回结果
        switch (isLeftNode) {

            case 1:
                return rightMin;
            case -1:
                return leftMax;
            case 0:
                return minDistance;
            default:
                return 0;

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
