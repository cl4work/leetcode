//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表 
// 👍 242 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}*/
// 输入: 4->2->1->3
//输出: 1->2->3->4
class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode sortedHead = null;
        ListNode index = head;
        while (index != null) {
            int val = index.val;
            sortedHead = insertNode(sortedHead, val);
            index = index.next;
        }
        return sortedHead;
    }

    private ListNode insertNode(ListNode sortedHead, int val) {

        ListNode temp = new ListNode(val);
        if (sortedHead == null) {
            return new ListNode(val);
        }
        if (val < sortedHead.val) {
            temp.next = sortedHead;
            return temp;
        }
        ListNode index = sortedHead;
        while (index.next != null) {
            if (val < index.next.val) {
                temp.next = index.next;
                index.next = temp;
                break;
            }
            index = index.next;
        }
        index.next = temp;
        return sortedHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
