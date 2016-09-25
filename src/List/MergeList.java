package List;

/**
 * Created by lwy on 2016/9/24.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                res = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                res = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            res.next = list1;
        }
        if (list2 != null) {
            res.next = list2;
        }
        return head.next;
    }
}
