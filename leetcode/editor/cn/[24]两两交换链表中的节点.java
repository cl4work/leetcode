//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 656 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode swapPairs(ListNode head) {

        //若为空，返回空
        if (head == null) {
            return null;
        }
        if (head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head = temp;
        } else {
            return head;
        }
        if (head.next.next != null) {
            head.next.next = swapPairs(head.next.next);
        }
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
