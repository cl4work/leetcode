//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 681 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}*/

class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }
        List<Integer> ls = new ArrayList<>();
        while (head != null) {

            ls.add(head.val);
            head = head.next;

        }
        for (int i = 0, j = ls.size() - 1; i <= j; ) {

            if (!ls.get(i).equals(ls.get(j))) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
