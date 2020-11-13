//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表 
// 👍 269 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

//Definition for singly-linked list.
/*public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/

class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (newHead != null) {
            listNodes.add(newHead);
            newHead = newHead.next;
        }
        for (int i = 0; i < listNodes.size(); ++i) {
            if (i + 2 < listNodes.size()) {
                listNodes.get(i).next = listNodes.get(i + 2);
            } else if ((i & 1) == 0) {
                listNodes.get(i).next = listNodes.get(1);
            } else {
                listNodes.get(i).next = null;
            }
        }
        return listNodes.get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
