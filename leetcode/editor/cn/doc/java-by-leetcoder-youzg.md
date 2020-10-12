### 解题思路
本题解 借鉴了 题解区几位大佬的思想：
> 中序遍历 目标**二叉搜索树**，每轮计算相邻节点的差值，并取最小

其主要应用原理为：
> 在二叉搜索树中，左 < 根 < 右
> 因此，最小差值，一定是相邻两个节点的差值
> 而 中根序，则保证了 上一轮遍历的根 与 当前遍历的根 **相邻(为父子关系)**

### 运行结果
![image.png](https://pic.leetcode-cn.com/1602464994-GipQuY-image.png)

### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int preNodeValue = -1;
    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return this.result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        /*
            中序遍历：
                计算每轮 上一轮遍历到的节点 和 当前节点 的 差绝对值
         */
        inorder(root.left);
        if (this.preNodeValue != -1) {
            this.result = Integer.min(Math.abs(root.val - this.preNodeValue), this.result);
        }
        this.preNodeValue = root.val;
        inorder(root.right);
    }
}
```
打卡第83天，加油！！！