//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1039 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//Definition for singly-linked list.
/* public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode l1 = head;
        ListNode l2 = head.next;
        for (int i = 0; i < n - 1; i++) {
            l2 = l2.next;
        }
        if (l2 == null) {
            return head.next;
        }
        while (l2.next != null) {

            l1 = l1.next;
            l2 = l2.next;

        }
        l1.next = l1.next.next;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
