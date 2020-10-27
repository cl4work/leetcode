//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 397 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /*public List<Integer> ret = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return ret;
        }
        addRet(root);
        return ret;
    }


    public void addRet(TreeNode root) {

        ret.add(root.val);
        if (root.left != null) {
            addRet(root.left);
        }
        if (root.right != null) {
            addRet(root.right);
        }
    }*/
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root == null) {
                if (stack.size() != 0) {
                    root = stack.pop();
                    root = root.right;

                } else {
                    return ret;
                }
            } else {
                ret.add(root.val);
                stack.push(root);
                root = root.left;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
